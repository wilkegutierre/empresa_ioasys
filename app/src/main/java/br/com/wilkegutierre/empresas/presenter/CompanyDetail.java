package br.com.wilkegutierre.empresas.presenter;

import br.com.wilkegutierre.empresas.data.network.CompanySelectedResult;

public interface CompanyDetail {

    interface CompanyDetailView {

        void companyDetailResult(CompanySelectedResult selectedResult);

        void showerror();
    }

    interface CompanyDetailPresenter {

        void setView(CompanyDetail.CompanyDetailView view);

        void searchSelectedCompany(int idCOmpany, String token, String client, String uid);
    }
}
