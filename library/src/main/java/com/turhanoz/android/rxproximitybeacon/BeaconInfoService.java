package com.turhanoz.android.rxproximitybeacon;

import com.turhanoz.android.rxproximitybeacon.model.Beacon;
import com.turhanoz.android.rxproximitybeacon.model.ListBeacons;
import com.turhanoz.android.rxproximitybeacon.model.ListBeaconsInfo;
import com.turhanoz.android.rxproximitybeacon.model.ListObservations;

import retrofit.http.Body;
import retrofit.http.POST;
import rx.Observable;

public interface BeaconInfoService {
    @POST("beacons:register")
    Observable<ListBeaconsInfo> getforobserved(@Body ListObservations listObservations);
}
