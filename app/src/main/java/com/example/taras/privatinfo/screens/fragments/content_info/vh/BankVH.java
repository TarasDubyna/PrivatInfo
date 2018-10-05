package com.example.taras.privatinfo.screens.fragments.content_info.vh;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.taras.privatinfo.R;
import com.example.taras.privatinfo.model.Bank;
import com.example.taras.privatinfo.model.PrivatItem;
import com.example.taras.privatinfo.screens.fragments.content_info.PrivatItemRecyclerAdapter;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class BankVH extends RecyclerView.ViewHolder {

    @BindView(R.id.tvName) TextView tvName;
    @BindView(R.id.tvAddress) TextView tvAddress;
    @BindView(R.id.tvPhone) TextView tvPhone;
    @BindView(R.id.tvEmail) TextView tvEmail;

    public BankVH(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    public void bind(PrivatItem dataItem) {
        tvName.setText(((Bank)dataItem).getName());
        tvAddress.setText(((Bank)dataItem).getAddress());
        tvPhone.setText(((Bank)dataItem).getPhone());
        tvEmail.setText(((Bank)dataItem).getEmail());
    }

}
