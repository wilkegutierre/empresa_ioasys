package br.com.wilkegutierre.empresas.data.network;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.moshi.MoshiConverterFactory;

public class ApiClient {

    public static String SERVER_ADDRESS = "https://empresas.ioasys.com.br/";

    private static Retrofit retrofitConn() {
        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient httpClient = new OkHttpClient.Builder().addInterceptor(loggingInterceptor).build();

        Retrofit retrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(SERVER_ADDRESS + "api/v1/")
                .client(httpClient)
                .build();

        return retrofit;
    }

    public static LoginService userLogin() {
        LoginService loginService = retrofitConn().create(LoginService.class);
        return loginService;
    }

    public static CompanyService companyService() {
        CompanyService service = retrofitConn().create(CompanyService.class);
        return service;
    }
}
