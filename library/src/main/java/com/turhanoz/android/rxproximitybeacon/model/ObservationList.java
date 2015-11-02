package com.turhanoz.android.rxproximitybeacon.model;

import java.util.ArrayList;

public class ObservationList {
    ArrayList<Observation> observations;
    ArrayList<String> namespacedTypes;

    public ObservationList(ArrayList<Observation> observations, ArrayList<String> namespacedTypes) {
        this.observations = observations;
        this.namespacedTypes = namespacedTypes;
    }

    @Override
    public String toString() {
        return "ObservationList{" +
                "observations=" + observations +
                ", namespacedTypes=" + namespacedTypes +
                '}';
    }
}
