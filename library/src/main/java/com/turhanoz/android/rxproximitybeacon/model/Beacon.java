package com.turhanoz.android.rxproximitybeacon.model;

import java.util.HashMap;

public class Beacon {
    public String beaconName;
    AdvertisedId advertisedId;
    BeaconStatus status;
    String placeId;
    LatLng latLng;
    IndoorLevel indoorLevel;
    BeaconStability expectedStability;
    String description;
    HashMap<String, String> properties;


    @Override
    public String toString() {
        return "Beacon{" +
                "beaconName='" + beaconName + '\'' +
                ", advertisedId=" + advertisedId +
                ", status=" + status +
                ", placeId='" + placeId + '\'' +
                ", latLng=" + latLng +
                ", indoorLevel=" + indoorLevel +
                ", expectedStability=" + expectedStability +
                ", description='" + description + '\'' +
                ", properties=" + properties +
                '}';
    }

    public String getSanitizedBeaconName() {
        if(beaconName.contains("/")){
            return beaconName.split("/")[1];
        }
        return beaconName;
    }
}
