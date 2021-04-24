package br.com.wilkegutierre.empresas.data.network;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class CompanySelectedResult {

    @SerializedName("enterprise")
    @Expose
    //private final CompanyResponse enterprises;
    //@Json(name = "enterprises")
    private final CompanyResponse enterprise;

    public CompanySelectedResult(CompanyResponse enterprise) {
        this.enterprise = enterprise;
    }

    public CompanyResponse getEnterprise() {
        return enterprise;
    }
}
