package br.com.wilkegutierre.empresas.data.network;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.squareup.moshi.Json;

public class CompanyTypeResponse {

    @SerializedName("id")
    @Expose
    private final int id;

    //@Json(name = "enterprise_type_name")
    @SerializedName("enterprise_type_name")
    @Expose
    private final String type_name;

    public CompanyTypeResponse(int id, String type_name) {
        this.id = id;
        this.type_name = type_name;
    }

    public int getId() {
        return id;
    }

    public String getType_name() {
        return type_name;
    }
}
