package com.example.imransk.json_parsing_retrofit_flower_bitm.AdapterClass;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.imransk.json_parsing_retrofit_flower_bitm.PojoClass.FlowersResponse;
import com.example.imransk.json_parsing_retrofit_flower_bitm.R;

import java.util.List;

public class FlowersAdapter extends ArrayAdapter<FlowersResponse> {
    Context context;
    List<FlowersResponse> flowersResponses;

    public FlowersAdapter(@NonNull Context context, List<FlowersResponse> flowersResponses) {
        super(context, R.layout.list_raw, flowersResponses);
        this.context = context;
        this.flowersResponses = flowersResponses;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        LayoutInflater layoutInflater= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView=layoutInflater.inflate(R.layout.list_raw,parent,false);

        TextView textView_id=convertView.findViewById(R.id.id_TV);
        TextView nameTextView=convertView.findViewById(R.id.name_TV_id);
        TextView priceTextView=convertView.findViewById(R.id.price_TV_ID);

        textView_id.setText(String.valueOf(flowersResponses.get(position).getProductId()));
        nameTextView.setText(flowersResponses.get(position).getName());
        priceTextView.setText(String.valueOf(flowersResponses.get(position).getPrice()));



        return convertView;
    }
}
