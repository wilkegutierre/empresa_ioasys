package br.com.wilkegutierre.empresas.data.network;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.squareup.moshi.Json;

import java.util.List;

public class CompanyResult {

    @SerializedName("enterprises")
    @Expose
    //private final CompanyResponse enterprises;
    //@Json(name = "enterprises")
    private final List<CompanyResponse> enterprises;

    public CompanyResult(List<CompanyResponse> enterprises) {
        this.enterprises = enterprises;
    }

    public List<CompanyResponse> getEnterprises() {
        return enterprises;
    }
}
