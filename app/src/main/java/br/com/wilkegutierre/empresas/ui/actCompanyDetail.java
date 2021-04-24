package br.com.wilkegutierre.empresas.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import br.com.wilkegutierre.empresas.R;
import br.com.wilkegutierre.empresas.adapter.ResultSearchAdapter;
import br.com.wilkegutierre.empresas.data.network.ApiClient;
import br.com.wilkegutierre.empresas.data.network.CompanyResponse;
import br.com.wilkegutierre.empresas.data.network.CompanyResult;
import br.com.wilkegutierre.empresas.data.network.CompanySelectedResult;
import br.com.wilkegutierre.empresas.presenter.CompanyDetail;
import br.com.wilkegutierre.empresas.presenter.CompanyDetailPresenter;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class actCompanyDetail
        extends AppCompatActivity
        implements CompanyDetail.CompanyDetailView {

    private ImageView imgBackButton, imgLogoCompany;
    private TextView tvNameCompany, tvContentCompany;
    private static int COMPANY;
    private String token, uid, client;
    private FrameLayout progressCompanyDetail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_company_detail);

        progressCompanyDetail = findViewById(R.id.progressCompanyDetail);
        imgBackButton = findViewById(R.id.imgBackButton);
        imgBackButton.setOnClickListener(closeDetail);
        imgLogoCompany = findViewById(R.id.imgLogoCompanyDetail);
        tvNameCompany = findViewById(R.id.tvNameCompanyDetail);
        tvContentCompany = findViewById(R.id.tvContentCompanyDetail);

        returnShared();
        bundleReturn();
        progressBarConnection();
        selectedCompany();
    }

    private void bundleReturn() {
        Bundle bundle = getIntent().getExtras();
        if ((bundle != null) && (bundle.containsKey("company"))) {
            COMPANY = (int) bundle.getSerializable("company");
        }
    }

    private void selectedCompany() {
        CompanyDetail.CompanyDetailPresenter companyPresenter = new CompanyDetailPresenter();
        companyPresenter.setView(this);
        companyPresenter.searchSelectedCompany(COMPANY, token, client, uid);
    }

    private View.OnClickListener closeDetail = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            finish();
        }
    };

    private void returnShared() {
        SharedPreferences preferences = getSharedPreferences("login_user", MODE_PRIVATE);
        token = preferences.getString("token", null);
        uid = preferences.getString("uid", null);
        client = preferences.getString("client", null);
    }

    private void progressBarConnection() {
        if (progressCompanyDetail.getVisibility() == View.VISIBLE) {
            progressCompanyDetail.setVisibility(View.GONE);
        } else {
            progressCompanyDetail.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public void companyDetailResult(CompanySelectedResult selectedResult) {
        progressBarConnection();
        tvNameCompany.setText(selectedResult.getEnterprise().getName());
        tvContentCompany.setText(selectedResult.getEnterprise().getDescription());
        loadPhoto(selectedResult.getEnterprise().getPhoto_url());
    }

    private void loadPhoto(String uriPhoto) {
        Glide.with(this)
                .load(ApiClient.SERVER_ADDRESS + uriPhoto)
                .centerCrop()
                .placeholder(R.drawable.image_launcher)
                .into(imgLogoCompany);
    }

    @Override
    public void showerror() {
        Toast.makeText(
                this,
                "Selected Company Failed!",
                Toast.LENGTH_SHORT).show();
    }

}