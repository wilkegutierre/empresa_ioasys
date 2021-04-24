package br.com.wilkegutierre.empresas.presenter;

import br.com.wilkegutierre.empresas.model.LoginModel;
import br.com.wilkegutierre.empresas.model.LoginResultModel;

public interface Login {

    interface LoginView {
        void paramsUserLogin(LoginResultModel loginResultModel);

        void showError();
    }


    interface LoginPresenter {

        void setView(LoginView view);

        void login(LoginModel loginRequest);
    }
}
