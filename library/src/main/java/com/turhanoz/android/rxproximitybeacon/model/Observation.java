package com.turhanoz.android.rxproximitybeacon.model;

public class Observation {
    AdvertisedId advertisedId;
    String telemetry;
    String timestampMs;

    public Observation(AdvertisedId advertisedId, String telemetry, String timestampMs) {
        this.advertisedId = advertisedId;
        this.telemetry = telemetry;
        this.timestampMs = timestampMs;
    }

    @Override
    public String toString() {
        return "Observation{" +
                "advertisedId=" + advertisedId +
                ", telemetry='" + telemetry + '\'' +
                ", timestampMs='" + timestampMs + '\'' +
                '}';
    }
}
