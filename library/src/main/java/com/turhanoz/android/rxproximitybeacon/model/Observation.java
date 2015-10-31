package com.turhanoz.android.rxproximitybeacon.model;

public class Observation {
    AdvertisedId advertisedId;
    String telemetry;
    String timestampMs;

    @Override
    public String toString() {
        return "Observation{" +
                "advertisedId=" + advertisedId +
                ", telemetry='" + telemetry + '\'' +
                ", timestampMs='" + timestampMs + '\'' +
                '}';
    }
}
