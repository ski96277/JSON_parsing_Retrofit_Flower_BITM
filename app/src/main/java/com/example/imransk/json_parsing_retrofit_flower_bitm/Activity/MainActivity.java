package com.example.imransk.json_parsing_retrofit_flower_bitm.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.imransk.json_parsing_retrofit_flower_bitm.AdapterClass.FlowersAdapter;
import com.example.imransk.json_parsing_retrofit_flower_bitm.ApiClass.Flowers_Api;
import com.example.imransk.json_parsing_retrofit_flower_bitm.PojoClass.FlowersResponse;
import com.example.imransk.json_parsing_retrofit_flower_bitm.R;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    public static String BASE_URL = "http://services.hanselandpetal.com/";

    ListView listView;
    FlowersAdapter flowersAdapter;
    List<FlowersResponse>flowersResponses=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = findViewById(R.id.list_view);
//list view on Item OnclickListnear
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                FlowersResponse flowersResponse=flowersResponses.get(i);
                startActivity(new Intent(MainActivity.this,DetailsActivity.class)
                .putExtra("flower",flowersResponse));

            }
        });

        //Retrofit
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        Flowers_Api flowersApi = retrofit.create(Flowers_Api.class);

        Call<List<FlowersResponse>> call = flowersApi.getAllFlowers();

        call.enqueue(new Callback<List<FlowersResponse>>() {
            @Override
            public void onResponse(Call<List<FlowersResponse>> call, Response<List<FlowersResponse>> response) {
                flowersResponses=response.body();
                flowersAdapter =new FlowersAdapter(MainActivity.this,flowersResponses);
                listView.setAdapter(flowersAdapter);


            }

            @Override
            public void onFailure(Call<List<FlowersResponse>> call, Throwable t) {

            }
        });


    }
}
