package br.com.wilkegutierre.empresas.presenter;

import br.com.wilkegutierre.empresas.data.network.ApiClient;
import br.com.wilkegutierre.empresas.model.LoginModel;
import br.com.wilkegutierre.empresas.model.LoginResultModel;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginPresenter implements Login.LoginPresenter {

    private Login.LoginView view;

    @Override
    public void setView(Login.LoginView view) {
        this.view = view;
    }

    @Override
    public void login(LoginModel loginRequest) {
        Call<LoginModel> loginResponse = ApiClient.userLogin().login(loginRequest);
        loginResponse.enqueue(new Callback<LoginModel>() {
            @Override
            public void onResponse(Call<LoginModel> call, Response<LoginModel> response) {
                if (response.isSuccessful()) {

                    LoginResultModel loginResultModel = new LoginResultModel();
                    loginResultModel.setToken(response.headers().get("access-token"));
                    loginResultModel.setUid(response.headers().get("uid"));
                    loginResultModel.setClient(response.headers().get("client"));

                    view.paramsUserLogin(loginResultModel);
                } else {
                    view.showError();
                }
            }

            @Override
            public void onFailure(Call<LoginModel> call, Throwable t) {
                view.showError();
            }
        });
    }
}
