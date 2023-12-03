package com.belajar.retrofit.service;

import com.belajar.retrofit.dto.GenderizeResponse;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
import retrofit2.http.Url;

public interface GenderizeRetrofitService {
    @GET //https://api.genderize.io?name=Andika use this if the API like this
    Call<GenderizeResponse> getGender(@Url String url, @Query("name") String name);



}
