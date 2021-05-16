package com.legend.yellowdusty;

import com.google.gson.Gson;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiRetrofit {
    @GET("/B552584/ArpltnStatsSvc/getCtprvnMesureLIst")
    Call<YellowdustDTO> getYellowDust(

            @Query("serviceKey") String key,
            @Query("returnType") String returnType,
            @Query("numOfRows") int num,
            @Query("pageNo") int page,
            @Query("itemCode") String itemCode,
            @Query("dataGubun") String type,
            @Query("searchCondition") String condition
    );
}
