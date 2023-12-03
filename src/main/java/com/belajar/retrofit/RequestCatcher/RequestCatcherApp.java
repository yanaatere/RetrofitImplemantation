package com.belajar.retrofit.RequestCatcher;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

import java.io.IOException;

public class RequestCatcherApp {
    public static void main(String[] args) throws IOException {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://belajar.requestcatcher.com/")
                .addConverterFactory(JacksonConverterFactory.create())
                .build();

        RequestCatcherService requestCatcherService = retrofit.create(RequestCatcherService.class);

        RequestCatcherRequest request = new RequestCatcherRequest(1, "Uswatun", 29);

        //By Default Dia Asynchronus
        Call<String> call = requestCatcherService.test(request);
        //Agar tidak asnc
        Response<String> execute = call.execute();
        System.out.println("execute = " + execute);
    }
}
