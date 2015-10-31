package com.turhanoz.android.rxproximitybeacon.model;

public class Namespace {
    String namespaceName;
    ServingVisibility servingVisibility;

    @Override
    public String toString() {
        return "Namespace{" +
                "namespaceName='" + namespaceName + '\'' +
                ", servingVisibility=" + servingVisibility +
                '}';
    }
}
