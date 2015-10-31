package com.turhanoz.android.rxproximitybeacon.model;

import java.util.ArrayList;

public class Diagnostic {
    String beaconName;
    BatteryDate estimatedLowBatteryDate;
    ArrayList<BeaconAlert> alerts;

    @Override
    public String toString() {
        return "Diagnostic{" +
                "beaconName='" + beaconName + '\'' +
                ", estimatedLowBatteryDate=" + estimatedLowBatteryDate +
                ", alerts=" + alerts +
                '}';
    }
}
