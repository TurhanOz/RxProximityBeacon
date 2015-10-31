package com.turhanoz.android.rxproximitybeacon.model;

import java.util.ArrayList;

public class ListDiagnostics {
    ArrayList<Diagnostic> diagnostics;
    String nextPageToken;

    @Override
    public String toString() {
        return "ListDiagnostics{" +
                "diagnostics=" + diagnostics +
                ", nextPageToken='" + nextPageToken + '\'' +
                '}';
    }
}
