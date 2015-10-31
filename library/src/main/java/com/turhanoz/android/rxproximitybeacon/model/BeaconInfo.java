package com.turhanoz.android.rxproximitybeacon.model;

import java.util.ArrayList;

public class BeaconInfo {
    AdvertisedId advertisedId;
    String beaconName;
    String description;
    ArrayList<AttachmentInfo> attachments;

    @Override
    public String toString() {
        return "BeaconInfo{" +
                "advertisedId=" + advertisedId +
                ", beaconName='" + beaconName + '\'' +
                ", description='" + description + '\'' +
                ", attachments=" + attachments +
                '}';
    }
}
