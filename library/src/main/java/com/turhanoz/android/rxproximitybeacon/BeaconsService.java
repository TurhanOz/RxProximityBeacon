package com.turhanoz.android.rxproximitybeacon;

import com.turhanoz.android.rxproximitybeacon.model.Beacon;
import com.turhanoz.android.rxproximitybeacon.model.ListBeacons;

import retrofit.http.Body;
import retrofit.http.GET;
import retrofit.http.Headers;
import retrofit.http.POST;
import retrofit.http.PUT;
import retrofit.http.Path;
import retrofit.http.Query;
import rx.Observable;

// TODO : There is a known issue with retrofit's path including "/"
// Fix all calls listed below, replacing beacons/{beaconName}
// by {beaconName} (which is stored in Beacon.beaconName
// https://github.com/square/retrofit/issues/1168
public interface BeaconsService {

    // TODO : fix path (see description)
    @POST("beacons/{beaconName}:activate")
    Observable<Void> activate(@Path("beaconName") String sanitizedBeaconName);

    // TODO : fix path (see description)
    @POST("beacons/{beaconName}:deactivate")
    Observable<Void> deactivate(@Path("beaconName") String sanitizedBeaconName);

    // TODO : fix path (see description)
    @POST("beacons/{beaconName}:decommission")
    Observable<Void> decommission(@Path("beaconName") String sanitizedBeaconName);

    // TODO : fix path (see description)
    @GET("beacons/{beaconName}")
    Observable<Beacon> get(@Path("beaconName") String sanitizedBeaconName);

    @GET("beacons")
    Observable<ListBeacons> list(@Query("q") String query);

    @POST("beacons\\:register")
    Observable<Beacon> register(@Body Beacon beacon);

    // TODO : fix path (see description)
    @PUT("beacons/{beaconName}")
    Observable<Beacon> update(@Path("beaconName") String sanitizedBeaconName, @Body Beacon beacon);
}
