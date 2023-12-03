package com.belajar.retrofit.service;

import com.belajar.retrofit.dto.GenderizeIoResponse;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface GenderizeService {

    @GET
    Call<GenderizeIoResponse> getGender(@Query("name") String name);
}
