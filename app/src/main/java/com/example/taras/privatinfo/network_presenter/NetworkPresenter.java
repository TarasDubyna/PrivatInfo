package com.example.taras.privatinfo.network_presenter;

import android.support.annotation.NonNull;
import android.util.Log;

import com.example.taras.privatinfo.network.repository.RepositoryProvider;

import rx.subscriptions.CompositeSubscription;

public class NetworkPresenter {
    private static final String LOG_TAG = NetworkPresenter.class.getSimpleName();

    private final NetworkPresenterView mView;
    private int endLoadSize = 0;

    public NetworkPresenter(@NonNull NetworkPresenterView mView) {
        this.mView = mView;
    }

    public void getAllATMs(){
        RepositoryProvider.getRepository()
                .getAllATMs()
                .subscribe(mView::getAllATMs, mView::showError);
    }

    public void getAllTerminals(){
        RepositoryProvider.getRepository()
                .getAllTerminals()
                .subscribe(mView::getAllTerminals, mView::showError);
    }

    public void getAllBanks(){
        RepositoryProvider.getRepository()
                .getAllBanks()
                .subscribe(mView::getAllBanks, mView::showError);
    }

    public void loadAll(){
        Log.d(LOG_TAG, "start loadAll");
        endLoadSize = 0;
        RepositoryProvider.getRepository()
                .getAllBanks()
                .subscribe(banks -> {
                    endLoadSize++;
                    checkIsLoadAll();
                }, mView::showError);
        RepositoryProvider.getRepository()
                .getAllTerminals()
                .subscribe(devices -> {
                    endLoadSize++;
                    checkIsLoadAll();
                }, mView::showError);
        RepositoryProvider.getRepository()
                .getAllATMs()
                .subscribe(devices -> {
                    endLoadSize++;
                    checkIsLoadAll();
                }, mView::showError);
    }

    private void checkIsLoadAll(){
        Log.d(LOG_TAG, "endLoadSize: " + endLoadSize);
        if (endLoadSize == 3){
            Log.d(LOG_TAG, "loading end");
            mView.allLoadingAreEnded();
        }
    }
}
