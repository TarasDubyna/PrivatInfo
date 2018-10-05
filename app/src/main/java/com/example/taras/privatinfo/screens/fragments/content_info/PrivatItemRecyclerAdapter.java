package com.example.taras.privatinfo.screens.fragments.content_info;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.taras.privatinfo.R;
import com.example.taras.privatinfo.model.PrivatItem;
import com.example.taras.privatinfo.screens.fragments.content_info.vh.BankVH;
import com.example.taras.privatinfo.screens.fragments.content_info.vh.DeviceVH;

import java.util.List;
import java.util.zip.Inflater;

public class PrivatItemRecyclerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<PrivatItem> dataCityList;
    private CityVH.ContentType contentType;

    public PrivatItemRecyclerAdapter(List<PrivatItem> dataCityList, CityVH.ContentType contentType) {
        this.dataCityList = dataCityList;
        this.contentType = contentType;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        RecyclerView.ViewHolder holder = null;
        if (contentType == CityVH.ContentType.BANK){
            holder = new BankVH(inflater.inflate(R.layout.vh_bank_item, parent, false));
        } else if (contentType == CityVH.ContentType.DEVICE){
            holder = new DeviceVH(inflater.inflate(R.layout.vh_device_item, parent, false));
        }
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if (contentType == CityVH.ContentType.BANK){
            ((BankVH) holder).bind(dataCityList.get(position));
        } else if (contentType == CityVH.ContentType.DEVICE){
            ((DeviceVH) holder).bind(dataCityList.get(position));
        }
    }

    @Override
    public int getItemCount() {
        return dataCityList.size();
    }

}
