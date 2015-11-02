package com.turhanoz.android.rxproximitybeaconsample.controller;

import android.util.Log;

import com.google.gson.Gson;
import com.turhanoz.android.rxproximitybeacon.BeaconsService;
import com.turhanoz.android.rxproximitybeacon.model.Beacon;
import com.turhanoz.android.rxproximitybeacon.model.BeaconList;
import com.turhanoz.android.rxproximitybeacon.util.HttpCodeUtils;
import com.turhanoz.android.rxproximitybeaconsample.RandomStringUtils;

import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class BeaconController {
    BeaconsService beaconsService;

    public BeaconController(BeaconsService beaconsService) {
        this.beaconsService = beaconsService;
    }

    public void runSequence(String sanitizedBeaconName) {
        list("");
        //Uncomment what you want to test


        // get(sanitizedBeaconName);
        // activate(sanitizedBeaconName);
        // deactivate(sanitizedBeaconName);

        // Beacon beacon = generateBeacon();
        // checkUpdate(beacon);
        // checkRegister(beacon);
        // checkDecommission(beacon.beaconName);
        // register(beacon);
    }


    private void get(String sanitizedBeaconName) {
        beaconsService.get(sanitizedBeaconName)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .unsubscribeOn(Schedulers.newThread())
                .subscribe(new Observer<Beacon>() {
                    @Override
                    public void onCompleted() {
                        Log.d("BEACON-GET", "onComplete");

                    }

                    @Override
                    public void onError(Throwable e) {
                        if (e instanceof retrofit.HttpException)
                            Log.d("BEACON-GET", "onError : " + e.toString());
                    }

                    @Override
                    public void onNext(Beacon beacon) {
                        Log.d("BEACON-GET", "onNext : " + beacon);

                    }
                });
    }

    private void checkDecommission(String beaconName) {
        Beacon beacon = new Beacon();
        beacon.beaconName = beaconName;
        decommission(beacon);
    }

    private void checkUpdate(Beacon beacon) {
        beacon.description = beacon.description + RandomStringUtils.random(2);
        update(beacon.getSanitizedBeaconName(), beacon);
    }

    private void checkRegister(Beacon beacon) {
        changeAdvertiseId(beacon);
        register(beacon);
    }


    private void list(String query) {
        beaconsService.list(query)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .unsubscribeOn(Schedulers.newThread())
                .subscribe(new Observer<BeaconList>() {
                    @Override
                    public void onCompleted() {
                        Log.d("BEACON-LIST", "onComplete");
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.d("BEACON-LIST", "onError " + e.toString());

                    }

                    @Override
                    public void onNext(BeaconList beaconList) {
                        Log.d("BEACON-LIST", "onNext : " + beaconList);

                    }
                });
    }

    private void activate(String sanitizedBeaconName) {
        beaconsService.activate(sanitizedBeaconName)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .unsubscribeOn(Schedulers.newThread())
                .subscribe(new Observer<Void>() {
                    @Override
                    public void onCompleted() {
                        Log.d("BEACON-ACTIVATE", "onComplete");
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.d("BEACON-ACTIVATE", "onError : " + e.toString());
                        if (HttpCodeUtils.isHttp400Error(e)) {
                            Log.d("BEACON-ACTIVATE", "Bad Request : unknown Beacon Name : register it first");
                        }
                    }

                    @Override
                    public void onNext(Void aVoid) {
                        Log.d("BEACON-ACTIVATE", "onNext : " + aVoid);
                    }
                });
    }

    private void deactivate(String sanitizedBeaconName) {
        beaconsService.deactivate(sanitizedBeaconName)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .unsubscribeOn(Schedulers.newThread())
                .subscribe(new Observer<Void>() {
                    @Override
                    public void onCompleted() {
                        Log.d("BEACON-DEACTIVATE", "onComplete");
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.d("BEACON-DEACTIVATE", "onError : " + e.toString());
                    }

                    @Override
                    public void onNext(Void aVoid) {
                        Log.d("BEACON-DEACTIVATE", "onNext : " + aVoid);
                    }
                });
    }

    private void update(String sanitizedBeaconName, Beacon beaconToSave) {
        beaconsService.update(sanitizedBeaconName, beaconToSave)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .unsubscribeOn(Schedulers.newThread())
                .subscribe(new Observer<Beacon>() {
                    @Override
                    public void onCompleted() {
                        Log.d("BEACON-UPDATE", "onComplete");

                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.d("BEACON-UPDATE", "onError : " + e.toString());
                    }

                    @Override
                    public void onNext(Beacon beacon) {
                        Log.d("BEACON-UPDATE", "onNext : " + beacon);

                    }
                });
    }

    private void changeAdvertiseId(Beacon beacon) {
        String advertisedId = beacon.advertisedId.id;
        advertisedId = RandomStringUtils.randomAlphabetic(1) + advertisedId.substring(1);
        beacon.advertisedId.id = advertisedId;
    }

    private void register(Beacon beacon) {
        beaconsService.register(beacon)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .unsubscribeOn(Schedulers.newThread())
                .subscribe(new Observer<Beacon>() {
                    @Override
                    public void onCompleted() {
                        Log.d("BEACON-REGISTER", "onComplete");
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.d("BEACON-REGISTER", "onError : " + e.toString());
                        if (HttpCodeUtils.isHttp409Error(e)) {
                            Log.d("BEACON-REGISTER", "conflicting (409), already registered once : " + e.toString());
                        }
                    }

                    @Override
                    public void onNext(Beacon beacon) {
                        Log.d("BEACON-REGISTER", "onNext : " + beacon);

                    }
                });
    }

    private void decommission(Beacon beacon) {
        beaconsService.decommission(beacon.getSanitizedBeaconName())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .unsubscribeOn(Schedulers.newThread())
                .subscribe(new Observer<Void>() {
                    @Override
                    public void onCompleted() {
                        Log.d("BEACON-DECOMMISSION", "onComplete");
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.d("BEACON-DECOMMISSION", "onError : " + e.toString());
                        if (HttpCodeUtils.isHttp400Error(e)) {
                            Log.d("BEACON-DECOMMISSION", "already decommissioned beacon " + e.toString());
                        } else if (HttpCodeUtils.isHttp404Error(e)) {
                            Log.d("BEACON-DECOMMISSION", "beacon not found" + e.toString());
                        }
                    }

                    @Override
                    public void onNext(Void aVoid) {
                        Log.d("BEACON-DECOMMISSION", "onNext " + aVoid);

                    }
                });
    }

    private Beacon generateBeacon() {
        String json = "{\n" +
                "    \"beaconName\": \"beacons/3!06be19f7c9d2a16d2180000000000002\",\n" +
                "    \"advertisedId\": {\n" +
                "    \"type\": \"EDDYSTONE\",\n" +
                "    \"id\": \"Br4Z98nSoW0hgAAAAAAAAg==\"\n" +
                "    },\n" +
                "    \"status\": \"ACTIVE\",\n" +
                "    \"placeId\": \"ChIJTxax6NoSkFQRWPvFXI1LypQ\",\n" +
                "    \"latLng\": {\n" +
                "    \"latitude\": 47.6693771,\n" +
                "    \"longitude\": -122.1966037\n" +
                "    },\n" +
                "    \"indoorLevel\": {\n" +
                "    \"name\": \"1\"\n" +
                "    },\n" +
                "    \"expectedStability\": \"STABLE\",\n" +
                "    \"description\": \"An example beacon.\",\n" +
                "    \"properties\": {\n" +
                "    \"position\": \"entryway\"\n" +
                "    }\n" +
                "    }";
        return new Gson().fromJson(json, Beacon.class);
    }
}
