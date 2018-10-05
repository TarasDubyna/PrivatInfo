package com.example.taras.privatinfo.screens.fragments.content_info;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ProgressBar;

import com.example.taras.privatinfo.R;
import com.example.taras.privatinfo.model.Bank;
import com.example.taras.privatinfo.model.Device;
import com.example.taras.privatinfo.network_presenter.NetworkPresenter;
import com.example.taras.privatinfo.network_presenter.NetworkPresenterView;
import com.example.taras.privatinfo.realm.model.DeviceDB;
import com.example.taras.privatinfo.utils.DataUtils;
import com.example.taras.privatinfo.utils.mapper.DeviceMapper;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.realm.Realm;
import io.realm.RealmResults;

public class ContentInfoFragment extends Fragment implements NetworkPresenterView {
    private static final String LOG_TAG = ContentInfoFragment.class.getSimpleName();

    @BindView(R.id.rvInfoContent) RecyclerView rvContent;
    @BindView(R.id.etSearch) EditText etSearch;
    @BindView(R.id.pbLoading) ProgressBar pbLoading;

    private ContentInfoRecyclerAdapter adapter;


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_info_content, container, false);
        ButterKnife.bind(this, rootView);
        showProgressBar(true);
        etSearch.addTextChangedListener(searchTextWatcher);

        Realm realm = Realm.getDefaultInstance();
        RealmResults<DeviceDB> results = realm.where(DeviceDB.class).findAll();
        List<Device> devices = new ArrayList<>(results.size());
        for (int i = 0; i < results.size(); i++) {
            devices.add(DeviceMapper.convert(results.get(i)));
        }

        Log.d(LOG_TAG, "devices.size: " + devices.size());

        adapter = new ContentInfoRecyclerAdapter(DataUtils.getSortedDevicesByCity(devices));
        rvContent.setLayoutManager(new LinearLayoutManager(getActivity()));
        rvContent.setAdapter(adapter);
        showProgressBar(false);

        return rootView;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);




        /*NetworkPresenter networkPresenter = new NetworkPresenter(this);
        networkPresenter.getAllATMs();*/
    }

    @Override
    public void getAllBanks(List<Bank> list) {

    }

    @Override
    public void getAllATMs(List<Device> deviceList) {
        Log.d(LOG_TAG, "getAllATMs response size: " + deviceList.size());
        adapter = new ContentInfoRecyclerAdapter(DataUtils.getSortedDevicesByCity(deviceList));
        rvContent.setLayoutManager(new LinearLayoutManager(getActivity()));
        rvContent.setAdapter(adapter);
        showProgressBar(false);
    }

    @Override
    public void getAllTerminals(List<Device> deviceList) {

    }

    @Override
    public void showError(Throwable throwable) {

    }

    @Override
    public void allLoadingAreEnded() {

    }

    TextWatcher searchTextWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            Log.d(LOG_TAG, "search onTextChanged text: " + s.toString());
            adapter.setCityForSearch(s.toString());
        }

        @Override
        public void afterTextChanged(Editable s) {

        }
    };

    private void showProgressBar(boolean isShowing){
        if (isShowing){
            pbLoading.setVisibility(View.VISIBLE);
            rvContent.setVisibility(View.GONE);
        } else {
            pbLoading.setVisibility(View.GONE);
            rvContent.setVisibility(View.VISIBLE);
        }
    }
}
