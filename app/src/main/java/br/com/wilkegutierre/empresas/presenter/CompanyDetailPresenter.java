package br.com.wilkegutierre.empresas.presenter;

import br.com.wilkegutierre.empresas.data.network.ApiClient;
import br.com.wilkegutierre.empresas.data.network.CompanySelectedResult;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CompanyDetailPresenter implements CompanyDetail.CompanyDetailPresenter {

    private CompanyDetail.CompanyDetailView view;

    @Override
    public void setView(CompanyDetail.CompanyDetailView view) {
        this.view = view;
    }

    @Override
    public void searchSelectedCompany(int idCOmpany, String token, String client, String uid) {
        ApiClient.companyService()
                .companyId(idCOmpany, token, client, uid).enqueue(new Callback<CompanySelectedResult>() {
            @Override
            public void onResponse(Call<CompanySelectedResult> call, Response<CompanySelectedResult> response) {
                if (response.isSuccessful()) {
                    view.companyDetailResult(response.body());
                } else {
                    view.showerror();
                }
            }

            @Override
            public void onFailure(Call<CompanySelectedResult> call, Throwable t) {
                view.showerror();
            }
        });
    }
}
