package br.com.wilkegutierre.empresas.data.network;

import br.com.wilkegutierre.empresas.model.LoginModel;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface LoginService {

    @POST("users/auth/sign_in/")
    Call<LoginModel> login(@Body LoginModel loginRequest);
}
