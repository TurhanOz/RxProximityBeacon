package com.turhanoz.android.rxproximitybeacon.mock;

import com.google.gson.Gson;
import com.turhanoz.android.rxproximitybeacon.BeaconsService;
import com.turhanoz.android.rxproximitybeacon.model.Beacon;
import com.turhanoz.android.rxproximitybeacon.model.ListBeacons;

import retrofit.http.Body;
import retrofit.http.Path;
import retrofit.http.Query;
import rx.Observable;

public class MockBeaconService extends MockService implements BeaconsService {
    @Override
    public Observable<Void> activate(@Path("beaconName") String sanitizedBeaconName) {
        return null;
    }

    @Override
    public Observable<Void> deactivate(@Path("beaconName") String sanitizedBeaconName) {
        return null;
    }

    @Override
    public Observable<Void> decommission(@Path("beaconName") String sanitizedBeaconName) {
        return null;
    }

    @Override
    public Observable<Beacon> get(@Path("beaconName") String sanitizedBeaconName) {
        return null;
    }

    @Override
    public Observable<ListBeacons> list(@Query("q") String query) {
        String beaconListAsString = getResponseAsString("beacons_list.json");
        ListBeacons listBeacons = new Gson().fromJson(beaconListAsString, ListBeacons.class);
        return Observable.just(listBeacons);
    }

    @Override
    public Observable<Beacon> register(@Body Beacon beacon) {
        return null;
    }

    @Override
    public Observable<Beacon> update(@Body Beacon beacon) {
        return null;
    }


}
