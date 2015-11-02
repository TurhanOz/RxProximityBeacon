package com.turhanoz.android.rxproximitybeaconsample.controller;

import android.util.Log;

import com.turhanoz.android.rxproximitybeacon.BeaconsDiagnosticsService;
import com.turhanoz.android.rxproximitybeacon.model.BeaconAlert;
import com.turhanoz.android.rxproximitybeacon.model.DiagnosticList;

import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class DiagnosticController {
    BeaconsDiagnosticsService diagnosticsService;

    public DiagnosticController(BeaconsDiagnosticsService diagnosticsService) {
        this.diagnosticsService = diagnosticsService;
    }

    public void runSequence(String sanitizedBeaconName) {
        list("-", 15, "", BeaconAlert.ALERT_UNSPECIFIED);
    }

    public void list(String sanitizedBeaconName, int pageSize, String pageToken, BeaconAlert alertFilter) {
        diagnosticsService.list(sanitizedBeaconName)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .unsubscribeOn(Schedulers.newThread())
                .subscribe(new Observer<DiagnosticList>() {
                    @Override
                    public void onCompleted() {
                        Log.d("LIST-DIAGNOSTICS", "onComplete");
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.d("LIST-DIAGNOSTICS", "onError : " + e.toString());
                    }

                    @Override
                    public void onNext(DiagnosticList diagnosticList) {
                        Log.d("LIST-DIAGNOSTICS", "onNext : " + diagnosticList.toString());

                    }
                });
    }
}
