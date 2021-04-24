package br.com.wilkegutierre.empresas.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.Toast;

import java.util.List;

import br.com.wilkegutierre.empresas.R;
import br.com.wilkegutierre.empresas.adapter.ResultSearchAdapter;
import br.com.wilkegutierre.empresas.data.network.ApiClient;
import br.com.wilkegutierre.empresas.data.network.CompanyResponse;
import br.com.wilkegutierre.empresas.data.network.CompanyResult;
import br.com.wilkegutierre.empresas.presenter.SearchCompany;
import br.com.wilkegutierre.empresas.presenter.SearchCompanyPresenter;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class actSearchResult
        extends AppCompatActivity
        implements SearchCompany.SearchCompanyView {

    private LinearLayout lnSearch;
    private EditText edtSearchCompany;
    private ImageView imgEmptySearchFiled;
    private RecyclerView rvSearchResult;
    private String token, uid, client;
    private ProgressBar progressSearch;
    private ResultSearchAdapter searchAdapter;
    private List<CompanyResponse> resultCompanyList;
    private FrameLayout fmSearchBegin, fmResultSearchNotFound;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_search_result);

        fmSearchBegin = findViewById(R.id.fmSearchBegin);
        searchBegin();

        fmResultSearchNotFound = findViewById(R.id.fmResultSearchNotFound);

        progressSearch = findViewById(R.id.progressSearchCompany);

        lnSearch = findViewById(R.id.layout_nav_search);
        lnSearch.setOnClickListener(hide_nav_search);

        edtSearchCompany = findViewById(R.id.edtSearchCompany);
        edtSearchCompany.addTextChangedListener(searchText);
        imgEmptySearchFiled = findViewById(R.id.imgEmptySearchFiled);
        imgEmptySearchFiled.setOnClickListener(emptySearchField);

        rvSearchResult = findViewById(R.id.rvSearchResult);
        rvSearchResult.setLayoutManager(new LinearLayoutManager(this));
        returnLoginShared();
    }

    private TextWatcher searchText = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {

        }

        @Override
        public void afterTextChanged(Editable editable) {
            if (editable.length() > 0) {
                searchBegin();
                progressBarConnection();
                searchCompanies(editable.toString());
            }
        }
    };

    private final View.OnClickListener hide_nav_search = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            lnSearch.setVisibility(View.GONE);
            edtSearchCompany.requestFocus();
            showSoftKey();
        }
    };

    private final View.OnClickListener emptySearchField = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            edtSearchCompany.getText().clear();
            edtSearchCompany.requestFocus();
            resultCompanyList.clear();
            searchAdapter.notifyDataSetChanged();
            showSoftKey();
        }
    };

    private void showSoftKey() {
        getWindow().setSoftInputMode(
                WindowManager.LayoutParams.SOFT_INPUT_STATE_VISIBLE);
    }

    private void searchCompanies(String companyName) {
        SearchCompany.SearchCompanyPresenter searchCompanyPresenter = new SearchCompanyPresenter();
        searchCompanyPresenter.setView(this);
        searchCompanyPresenter.searchComapny(companyName, token, client, uid);
    }

    private void returnLoginShared() {
        SharedPreferences preferences = getSharedPreferences("login_user", MODE_PRIVATE);
        token = preferences.getString("token", null);
        uid = preferences.getString("uid", null);
        client = preferences.getString("client", null);
    }

    private void progressBarConnection() {
        if (progressSearch.getVisibility() == View.VISIBLE) {
            progressSearch.setVisibility(View.GONE);
        } else {
            progressSearch.setVisibility(View.VISIBLE);
        }
    }

    private void searchBegin() {
        if (fmSearchBegin.getVisibility() == View.VISIBLE) {
            fmSearchBegin.setVisibility(View.GONE);
        } else {
            fmSearchBegin.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public void companyResult(List<CompanyResponse> resultCompanyList) {
        progressBarConnection();
        this.resultCompanyList = resultCompanyList;
        searchAdapter = new ResultSearchAdapter(resultCompanyList);
        rvSearchResult.setAdapter(searchAdapter);
        if (resultCompanyList.size() > 0) {
            fmResultSearchNotFound.setVisibility(View.GONE);
        } else {
            fmResultSearchNotFound.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public void showError() {
        Toast.makeText(
                this,
                "Search Failed!",
                Toast.LENGTH_SHORT).show();
    }
}