package com.turhanoz.android.rxproximitybeacon;

import com.turhanoz.android.rxproximitybeacon.model.ListNamespaces;

import retrofit.http.GET;
import rx.Observable;

public interface NamespacesService {
    @GET("namespaces")
    Observable<ListNamespaces> list();
}
