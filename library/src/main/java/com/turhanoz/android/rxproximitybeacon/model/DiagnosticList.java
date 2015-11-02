package com.turhanoz.android.rxproximitybeacon.model;

import java.util.ArrayList;

public class DiagnosticList {
    ArrayList<Diagnostic> diagnostics;
    String nextPageToken;

    @Override
    public String toString() {
        return "DiagnosticList{" +
                "diagnostics=" + diagnostics +
                ", nextPageToken='" + nextPageToken + '\'' +
                '}';
    }
}
