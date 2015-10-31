package com.turhanoz.android.rxproximitybeacon.model;

public class AdvertisedId {
    BeaconType type;
    String id;

    @Override
    public String toString() {
        return "AdvertiseId{" +
                "type='" + type + '\'' +
                ", id='" + id + '\'' +
                '}';
    }
}
