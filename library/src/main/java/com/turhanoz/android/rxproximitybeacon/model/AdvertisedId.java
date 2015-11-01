package com.turhanoz.android.rxproximitybeacon.model;

public class AdvertisedId {
    BeaconType type;
    String id;


    public AdvertisedId(BeaconType type, String id) {
        this.type = type;
        this.id = id;
    }

    @Override
    public String toString() {
        return "AdvertiseId{" +
                "type='" + type + '\'' +
                ", id='" + id + '\'' +
                '}';
    }
}
