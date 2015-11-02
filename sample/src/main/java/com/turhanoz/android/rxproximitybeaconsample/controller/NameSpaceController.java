package com.turhanoz.android.rxproximitybeaconsample.controller;

import android.util.Log;

import com.turhanoz.android.rxproximitybeacon.NamespacesService;
import com.turhanoz.android.rxproximitybeacon.model.NamespaceList;

import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class NameSpaceController {
    NamespacesService namespacesService;

    public NameSpaceController(NamespacesService namespacesService) {
        this.namespacesService = namespacesService;
    }

    public void runSequence() {
        listNamespaces();
    }

    public void listNamespaces() {
        namespacesService.list()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .unsubscribeOn(Schedulers.newThread())
                .subscribe(new Observer<NamespaceList>() {
                    @Override
                    public void onCompleted() {
                        Log.d("LIST-NAMESPACE", "onComplete");
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.d("LIST-NAMESPACE", "onError: " + e.toString());
                    }

                    @Override
                    public void onNext(NamespaceList namespaceList) {
                        Log.d("LIST-NAMESPACE", "onNext" + namespaceList.toString());
                    }
                });
    }
}
