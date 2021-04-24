package br.com.wilkegutierre.empresas.presenter;

import br.com.wilkegutierre.empresas.data.network.ApiClient;
import br.com.wilkegutierre.empresas.data.network.CompanyResult;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SearchCompanyPresenter
        implements SearchCompany.SearchCompanyPresenter {

    private SearchCompany.SearchCompanyView view;

    @Override
    public void setView(SearchCompany.SearchCompanyView view) {
        this.view = view;
    }

    @Override
    public void searchComapny(String companyName, String token, String client, String uid) {
        ApiClient.companyService()
                .companyWithFilter(companyName, token, client, uid)
                .enqueue(new Callback<CompanyResult>() {
                    @Override
                    public void onResponse(Call<CompanyResult> call, Response<CompanyResult> response) {
                        if (response.isSuccessful()) {
                            view.companyResult(response.body().getEnterprises());
                        } else {
                            view.showError();
                        }
                    }

                    @Override
                    public void onFailure(Call<CompanyResult> call, Throwable t) {
                        view.showError();
                    }
                });
    }
}
