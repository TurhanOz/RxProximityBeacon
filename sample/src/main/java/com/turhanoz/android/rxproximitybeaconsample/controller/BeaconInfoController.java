package com.turhanoz.android.rxproximitybeaconsample.controller;

import android.util.Log;

import com.turhanoz.android.rxproximitybeacon.BeaconInfoService;
import com.turhanoz.android.rxproximitybeacon.model.AdvertisedId;
import com.turhanoz.android.rxproximitybeacon.model.BeaconType;
import com.turhanoz.android.rxproximitybeacon.model.BeaconInfoList;
import com.turhanoz.android.rxproximitybeacon.model.ObservationList;
import com.turhanoz.android.rxproximitybeacon.model.Observation;

import java.util.ArrayList;

import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class BeaconInfoController {
    BeaconInfoService beaconInfoService;
    String apiKey;

    public BeaconInfoController(BeaconInfoService beaconInfoService, String apiKey) {
        this.beaconInfoService = beaconInfoService;
        this.apiKey = apiKey;
    }

    public void runSequence(String stringAdvertisedId, String nameSpace) {
        AdvertisedId advertisedId = new AdvertisedId(BeaconType.EDDYSTONE, stringAdvertisedId);
        Observation observation = new Observation(advertisedId, null, null);
        ArrayList<Observation> observations = new ArrayList<>();
        ArrayList<String> namespaces = new ArrayList<>();

        observations.add(observation);
        namespaces.add(nameSpace);

        getForObserved(new ObservationList(observations, namespaces));
    }


    public void getForObserved(ObservationList observationList) {
        beaconInfoService.getForObserved(apiKey, observationList)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .unsubscribeOn(Schedulers.newThread())
                .subscribe(new Observer<BeaconInfoList>() {
                    @Override
                    public void onCompleted() {
                        Log.d("BEACON-INFO", "onComplete");
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.d("BEACON-INFO", "onError : " + e.toString());
                    }

                    @Override
                    public void onNext(BeaconInfoList beaconInfoList) {
                        Log.d("BEACON-INFO", "onNext : " + beaconInfoList.toString());
                    }
                });
    }
}

