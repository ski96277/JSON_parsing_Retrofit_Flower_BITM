package com.example.imransk.json_parsing_retrofit_flower_bitm.ApiClass;

import com.example.imransk.json_parsing_retrofit_flower_bitm.PojoClass.FlowersResponse;
import com.google.gson.annotations.SerializedName;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Flowers_Api {

    @GET("feeds/flowers.json")
    Call<List<FlowersResponse>>getAllFlowers();
}
