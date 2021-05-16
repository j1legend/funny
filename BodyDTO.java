package com.legend.yellowdusty;

import com.google.gson.annotations.SerializedName;

import java.util.Map;

public class BodyDTO {
    @SerializedName("totalCount")
    int totalCount;

    @SerializedName("items")
    Map<String,String>[] items;

    @SerializedName("pageNo")
    int pageNumber;

    @SerializedName("numOfRows")
    int numOfRows;
}
