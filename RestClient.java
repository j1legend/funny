package com.legend.yellowdusty;

import com.google.gson.Gson;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RestClient {
    ApiRetrofit api;
    Retrofit retrofit;

    RestClient() {
        Retrofit.Builder builder = new Retrofit.Builder();
        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
        loggingInterceptor.level(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(loggingInterceptor)
                .build();

        retrofit = builder
                .baseUrl("http://apis.data.go.kr/")
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        api = retrofit.create(ApiRetrofit.class);

    }


    Call<YellowdustDTO> getYellowDustInfo() {
        return api.getYellowDust(
                "oH/X7xn4oN36ASMLe+wfTzhQzAeVEpkxdqPOScVy/hJg/o7UmNf096D9d5lntQwhkT4kp1wnj6fiUQsKK4G07w==",
                "json",
                5,
                1,
                "PM10",
                "HOUR",
                "WEEK");
    }
}
