package com.example.taras.privatinfo.screens.fragments.content_info;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.taras.privatinfo.R;
import com.example.taras.privatinfo.model.Bank;
import com.example.taras.privatinfo.model.Device;
import com.example.taras.privatinfo.model.PrivatItem;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


public class CityVH extends RecyclerView.ViewHolder {

    @BindView(R.id.tvCity) TextView tvCity;
    @BindView(R.id.rvItems) RecyclerView rvItems;

    private String cityName;

    enum ContentType{
        BANK,
        DEVICE
    }

    private ContentType contentType;
    private PrivatItemRecyclerAdapter adapter;


    public CityVH(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    void bind(List<PrivatItem> dataCityList) {
        checkType(dataCityList.get(0));
        tvCity.setText(cityName.toString());

        adapter = new PrivatItemRecyclerAdapter(dataCityList, contentType);
        rvItems.setLayoutManager(new LinearLayoutManager(this.itemView.getContext()));
        rvItems.setAdapter(adapter);
    }


    private void checkType(PrivatItem item){
        if (item.getType() == null){
            contentType = ContentType.BANK;
            cityName = ((Bank)item).getCity();
        } else {
            contentType = ContentType.DEVICE;
            cityName = ((Device)item).getCityRU();
        }
    }

}
