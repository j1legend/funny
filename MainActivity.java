package com.legend.yellowdusty;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ClipData;
import android.os.Bundle;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    TextView txt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txt = findViewById(R.id.txt);

        RestClient client = new RestClient();
        client.getYellowDustInfo().enqueue(new Callback<YellowdustDTO>() {

            @Override
            public void onResponse(Call<YellowdustDTO> call, Response<YellowdustDTO> response) {
                YellowdustDTO yellowdustDTO = response.body();
                ResponseDTO responseDTO = yellowdustDTO.response;
                BodyDTO bodyDTO = responseDTO.body;
                Map<String,String>[] data = bodyDTO.items;
                txt.setText(data[0].get("seoul"));
            }

            @Override
            public void onFailure(Call<YellowdustDTO> call, Throwable t) {

            }
        });
    }
}