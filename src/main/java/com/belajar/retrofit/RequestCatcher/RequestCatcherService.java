package com.belajar.retrofit.RequestCatcher;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface RequestCatcherService {

    @POST("/test")
    Call<String> test(@Body RequestCatcherRequest request);
}
