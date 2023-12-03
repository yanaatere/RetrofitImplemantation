package com.belajar.retrofit.service;

import com.belajar.retrofit.dto.BaseResponse;
import com.belajar.retrofit.dto.GenderizeResponse;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import retrofit2.*;
import retrofit2.converter.jackson.JacksonConverterFactory;

import java.io.IOException;

@Service
public class GanderizeService {
    public BaseResponse getGender(String name) throws IOException {

        final GenderizeResponse[] body = {new GenderizeResponse()};

        String baseUrl = "https://api.genderize.io/";
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(JacksonConverterFactory.create())
                .build();

        GenderizeRetrofitService genderizeRetrofitService = retrofit.create(GenderizeRetrofitService.class);
        Call<GenderizeResponse> call = genderizeRetrofitService.getGender(baseUrl, name);
        Response<GenderizeResponse> response = call.execute();
        if(response.isSuccessful()) {
            return new BaseResponse(HttpStatus.OK.value(), "Find All", response.body());
        } else {
            return new BaseResponse();
        }

       /*
       Asynchronous Method
       call.enqueue(new Callback<GenderizeResponse>() {
            @Override
            public void onResponse(Call<GenderizeResponse> call, Response<GenderizeResponse> response) {
                if(response.isSuccessful()){
                    body[0] = response.body();
                }
            }

            @Override
            public void onFailure(Call<GenderizeResponse> call, Throwable throwable) {

            }
        });*/


    }
}
