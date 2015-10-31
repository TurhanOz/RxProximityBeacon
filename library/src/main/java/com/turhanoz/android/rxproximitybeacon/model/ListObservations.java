package com.turhanoz.android.rxproximitybeacon.model;

import java.util.ArrayList;

public class ListObservations {
    ArrayList<Observation> observations;
    ArrayList<String> namespacedTypes;

    @Override
    public String toString() {
        return "ListObservations{" +
                "observations=" + observations +
                ", namespacedTypes=" + namespacedTypes +
                '}';
    }
}
