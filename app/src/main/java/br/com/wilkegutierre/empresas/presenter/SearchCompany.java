package br.com.wilkegutierre.empresas.presenter;


import java.util.List;

import br.com.wilkegutierre.empresas.data.network.CompanyResponse;

public interface SearchCompany {

    interface SearchCompanyView {
        void companyResult(List<CompanyResponse> resultCompanyList);

        void showError();
    }


    interface SearchCompanyPresenter {

        void setView(SearchCompanyView view);

        void searchComapny(String companyName, String token, String client, String uid);
    }
}
