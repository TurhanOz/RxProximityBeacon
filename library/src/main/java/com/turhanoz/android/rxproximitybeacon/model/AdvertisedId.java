package com.turhanoz.android.rxproximitybeacon.model;

import com.turhanoz.android.rxproximitybeacon.util.EncodeUtils;

public class AdvertisedId {
    BeaconType type;
    public String id; //base64 encoded


    public AdvertisedId(BeaconType type, String id) {
        this.type = type;
        this.id = id;
    }

    @Override
    public String toString() {
        return "AdvertiseId{" +
                "type='" + type + '\'' +
                ", encoded id='" + id + '\'' +
                ", decoded id='" + EncodeUtils.base64Decode(id).toString() + '\'' +
                '}';
    }
}
