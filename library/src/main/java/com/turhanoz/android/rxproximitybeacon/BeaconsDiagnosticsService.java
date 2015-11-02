package com.turhanoz.android.rxproximitybeacon;

import com.turhanoz.android.rxproximitybeacon.model.BeaconAlert;
import com.turhanoz.android.rxproximitybeacon.model.DiagnosticList;

import retrofit.http.GET;
import retrofit.http.Path;
import retrofit.http.Query;
import rx.Observable;

// TODO : There is a known issue with retrofit's path including "/"
// Fix all calls listed below, replacing beacons/{beaconName}
// by {beaconName} (which is stored in Beacon.beaconName
// https://github.com/square/retrofit/issues/1168
public interface BeaconsDiagnosticsService {

    // TODO : fix path (see description)
    @GET("beacons/{beaconName}/diagnostics")
    Observable<DiagnosticList> list(@Path("beaconName") String sanitizedBeaconName,
                                     @Query("pageSize") int pageSize,
                                     @Query("pageToken") String pageToken,
                                     @Query("alertFilter") BeaconAlert alertFilter);

    // TODO : fix path (see description)
    @GET("beacons/{beaconName}/diagnostics")
    Observable<DiagnosticList> list(@Path("beaconName") String sanitizedBeaconName);
}
