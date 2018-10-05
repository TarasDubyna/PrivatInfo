package com.example.taras.privatinfo;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.taras.privatinfo.model.Bank;
import com.example.taras.privatinfo.model.Device;
import com.example.taras.privatinfo.network_presenter.NetworkPresenter;
import com.example.taras.privatinfo.network_presenter.NetworkPresenterView;
import com.example.taras.privatinfo.screens.InfoActivity;
import com.example.taras.privatinfo.utils.DataUtils;
import com.example.taras.privatinfo.utils.DateUtils;
import com.example.taras.privatinfo.utils.PreferenceUtils;

import java.util.List;


public class MainActivity extends AppCompatActivity {
    private static final String LOG_TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED ) {
            if (ActivityCompat.shouldShowRequestPermissionRationale(this,
                    android.Manifest.permission.ACCESS_COARSE_LOCATION)) {
                Log.d(LOG_TAG, "don`t request the permission");
                checkForUpdate();
            } else {
                Log.d(LOG_TAG, "do request the permission");
                ActivityCompat.requestPermissions(this, new String[]{android.Manifest.permission.ACCESS_FINE_LOCATION}, 8);
                checkForUpdate();
            }
        } else {
            checkForUpdate();
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        Log.d(LOG_TAG, "onRequestPermissionsResult");
    }

    private void checkForUpdate(){
        if (PreferenceUtils.getLastTimestampUpdate() == 0 || DateUtils.isWeekAgo()){
            takeRequest();
        } else {
            startActivity();
        }
    }

    private void startActivity(){
        startActivity(new Intent(this, InfoActivity.class));
        finish();
    }

    private void takeRequest(){
        NetworkPresenter presenter = new NetworkPresenter(presenterCallback);
        presenter.loadAll();
    }

    NetworkPresenterView presenterCallback = new NetworkPresenterView() {
        @Override
        public void getAllBanks(List<Bank> list) {

        }

        @Override
        public void getAllATMs(List<Device> response) {

        }

        @Override
        public void getAllTerminals(List<Device> response) {

        }

        @Override
        public void showError(Throwable throwable) {

        }

        @Override
        public void allLoadingAreEnded() {
            PreferenceUtils.saveLastTimestampUpdate(DateUtils.getCurrentTimestamp());
            startActivity();
        }
    };


}

