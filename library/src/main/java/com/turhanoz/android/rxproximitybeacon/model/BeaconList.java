package com.turhanoz.android.rxproximitybeacon.model;

import java.util.ArrayList;

public class BeaconList {
    public ArrayList<Beacon> beacons;
    String nextPageToken;
    String totalCount;

    @Override
    public String toString() {
        return "ListBeacons{" +
                "beacons=" + beacons +
                ", nextPageToken='" + nextPageToken + '\'' +
                ", totalCount='" + totalCount + '\'' +
                '}';
    }
}
