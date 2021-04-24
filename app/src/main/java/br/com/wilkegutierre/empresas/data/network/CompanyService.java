package br.com.wilkegutierre.empresas.data.network;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Part;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface CompanyService {

    @GET("enterprises")
    Call<CompanyResult> companyWithFilter(@Query("name") String name,
                                          @Header("access-token") String token,
                                          @Header("client") String client,
                                          @Header("uid") String uid);

    @GET("enterprises/{idCompany}")
    Call<CompanySelectedResult> companyId(@Path("idCompany") int idCompany,
                                    @Header("access-token") String token,
                                    @Header("client") String client,
                                    @Header("uid") String uid);
}
