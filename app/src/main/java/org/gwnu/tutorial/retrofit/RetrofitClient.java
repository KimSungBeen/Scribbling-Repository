package org.gwnu.tutorial.retrofit;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {
    private static RetrofitClient ourInstance = new RetrofitClient();
    public static RetrofitClient getInstance() {
        return ourInstance;
    }
    private RetrofitClient() {
    }

    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("https://api.github.com/")
            .addConverterFactory(GsonConverterFactory.create()) // 파싱등록
            .build();

    RetrofitService service = retrofit.create(RetrofitService.class);

    public RetrofitService getService() {
        return service;
    }
}
