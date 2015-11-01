package com.turhanoz.android.rxproximitybeacon;

import com.turhanoz.android.rxproximitybeacon.model.ListBeaconsInfo;
import com.turhanoz.android.rxproximitybeacon.model.ListObservations;

import retrofit.http.Body;
import retrofit.http.POST;
import retrofit.http.Query;
import rx.Observable;

public interface BeaconInfoService {
    @POST("beaconinfo\\:getforobserved")
    Observable<ListBeaconsInfo> getForObserved(@Query("key") String key, @Body ListObservations listObservations);
}
