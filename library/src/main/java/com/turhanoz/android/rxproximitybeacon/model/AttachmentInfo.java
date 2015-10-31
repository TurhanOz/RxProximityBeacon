package com.turhanoz.android.rxproximitybeacon.model;

public class AttachmentInfo {
    String namespacedType;
    String data;

    @Override
    public String toString() {
        return "AttachmentInfo{" +
                "namespacedType='" + namespacedType + '\'' +
                ", data='" + data + '\'' +
                '}';
    }
}
