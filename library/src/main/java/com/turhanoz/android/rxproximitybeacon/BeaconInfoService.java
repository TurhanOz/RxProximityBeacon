package com.turhanoz.android.rxproximitybeacon;

import com.turhanoz.android.rxproximitybeacon.model.BeaconInfoList;
import com.turhanoz.android.rxproximitybeacon.model.ObservationList;

import retrofit.http.Body;
import retrofit.http.POST;
import retrofit.http.Query;
import rx.Observable;

public interface BeaconInfoService {
    @POST("beaconinfo\\:getforobserved")
    Observable<BeaconInfoList> getForObserved(@Query("key") String key, @Body ObservationList observationList);
}
