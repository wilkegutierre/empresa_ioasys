package br.com.wilkegutierre.empresas.data.network;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.squareup.moshi.Json;

import java.util.List;
import java.util.Map;

public class CompanyResponse {

    //@Json(name = "id")
    @SerializedName("id")
    @Expose
    private final int id;

    //@Json(name = "enterprise_name")
    @SerializedName("enterprise_name")
    @Expose
    private final String name;

    //@Json(name = "description")
    @SerializedName("description")
    @Expose
    private final String description;

    //@Json(name = "city")
    @SerializedName("city")
    @Expose
    private final String city;

    //@Json(name = "enterprise_type")
    @SerializedName("enterprise_type")
    @Expose
    private final CompanyTypeResponse enterprise_type;

    @SerializedName("photo")
    @Expose
    private final String photo_url;

    public CompanyResponse(
            int id, String name, String description,
            String city, CompanyTypeResponse enterprise_type, String photo_url) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.city = city;
        this.enterprise_type = enterprise_type;
        this.photo_url = photo_url;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getCity() {
        return city;
    }

    public CompanyTypeResponse getEnterprise_type() {
        return enterprise_type;
    }

    public String getPhoto_url() {
        return photo_url;
    }
}
