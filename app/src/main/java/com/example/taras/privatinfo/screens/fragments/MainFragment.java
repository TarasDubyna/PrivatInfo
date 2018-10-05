package com.example.taras.privatinfo.screens.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.taras.privatinfo.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainFragment extends Fragment {

    @BindView(R.id.btnAround) Button btnAround;
    @BindView(R.id.btnAll) Button btnAll;
    @BindView(R.id.btnBanks) Button btnBanks;
    @BindView(R.id.btnBankomats) Button btnBankomats;
    @BindView(R.id.btnTerminals) Button btnTerminals;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_main, container, false);
        ButterKnife.bind(this, rootView);
        return rootView;
    }

    @OnClick({R.id.btnAround, R.id.btnAll, R.id.btnBanks, R.id.btnBankomats, R.id.btnTerminals})
    public void click(View view) {
        switch (view.getId()){
            case R.id.btnAround:
                break;
            case R.id.btnAll:
                break;
            case R.id.btnBanks:
                break;
            case R.id.btnBankomats:
                break;
            case R.id.btnTerminals:
                break;
        }
    }

}
