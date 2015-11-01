package com.turhanoz.android.rxproximitybeacon.model;

import java.util.ArrayList;

public class ListObservations {
    ArrayList<Observation> observations;
    ArrayList<String> namespacedTypes;

    public ListObservations(ArrayList<Observation> observations, ArrayList<String> namespacedTypes) {
        this.observations = observations;
        this.namespacedTypes = namespacedTypes;
    }

    @Override
    public String toString() {
        return "ListObservations{" +
                "observations=" + observations +
                ", namespacedTypes=" + namespacedTypes +
                '}';
    }
}
