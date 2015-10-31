package com.turhanoz.android.rxproximitybeacon.model;

import java.util.ArrayList;

public class ListBeaconsInfo {
    ArrayList<BeaconInfo> beacons;

    @Override
    public String toString() {
        return "ListBeaconsInfo{" +
                "beacons=" + beacons +
                '}';
    }
}
