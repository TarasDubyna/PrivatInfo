package com.example.taras.privatinfo.screens.fragments.content_info.vh;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.taras.privatinfo.R;
import com.example.taras.privatinfo.model.Bank;
import com.example.taras.privatinfo.model.Device;
import com.example.taras.privatinfo.model.PrivatItem;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DeviceVH extends RecyclerView.ViewHolder {

    @BindView(R.id.tvDeviceType)TextView tvDeviceType;
    @BindView(R.id.tvName)TextView tvName;
    @BindView(R.id.tvAddress) TextView tvAddress;

    public DeviceVH(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    public void bind(PrivatItem dataItem) {
        tvDeviceType.setText(dataItem.getType());
        tvName.setText(((Device)dataItem).getPlaceRu());
        tvAddress.setText(((Device)dataItem).getFullAddressRu());
    }
}
