package com.example.imransk.json_parsing_retrofit_flower_bitm.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.imransk.json_parsing_retrofit_flower_bitm.PojoClass.FlowersResponse;
import com.example.imransk.json_parsing_retrofit_flower_bitm.R;
import com.squareup.picasso.Picasso;

public class DetailsActivity extends AppCompatActivity {

    ImageView imageView;
    TextView name_Tv;
    TextView price_Tv;
    TextView catagory_Tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        FlowersResponse flowersResponse= (FlowersResponse) getIntent().getSerializableExtra("flower");

        imageView=findViewById(R.id.imageView_ID);
        name_Tv=findViewById(R.id.textView_name_ID);
        price_Tv=findViewById(R.id.textView_price_ID);
        catagory_Tv=findViewById(R.id.text_view_catagory_id);
String flower_URL=MainActivity.BASE_URL+"photos/"+flowersResponse.getPhoto();
        Picasso.get().load(flower_URL).into(imageView);
        name_Tv.append(flowersResponse.getName());
        price_Tv.append(String.valueOf(flowersResponse.getPrice())+" Tk");
        catagory_Tv.append(flowersResponse.getCategory());


    }
}
