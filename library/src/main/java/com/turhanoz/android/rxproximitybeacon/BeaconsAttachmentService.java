package com.turhanoz.android.rxproximitybeacon;

import com.turhanoz.android.rxproximitybeacon.model.BeaconAttachment;
import com.turhanoz.android.rxproximitybeacon.model.DeletedAttachmentsCount;
import com.turhanoz.android.rxproximitybeacon.model.BeaconAttachmentList;

import retrofit.http.Body;
import retrofit.http.DELETE;
import retrofit.http.GET;
import retrofit.http.POST;
import retrofit.http.Path;
import retrofit.http.Query;
import rx.Observable;

// TODO : There is a known issue with retrofit's path including "/"
// Fix all calls listed below, replacing beacons/{beaconName}
// by {beaconName} (which is stored in Beacon.beaconName
// https://github.com/square/retrofit/issues/1168
// http://stackoverflow.com/questions/33127914/retrofit-2-0-beta-2-issue-with-path-encoding
public interface BeaconsAttachmentService {
    // TODO : fix path (see description)
    @POST("beacons/{beaconName}/attachments:batchDelete")
    Observable<Integer> batchDelete(@Path("beaconName") String beaconName, @Query("namespacedType") String nameSpacedType);

    // TODO : fix path (see description)
    @POST("beacons/{beaconName}/attachments:batchDelete?namespacedType=*/*")
    Observable<DeletedAttachmentsCount> batchDelete(@Path("beaconName") String beaconName);

    // TODO : fix path (see description)
    @POST("beacons/{beaconName}/attachments")
    Observable<BeaconAttachment> create(@Path("beaconName") String beaconName, @Body BeaconAttachment beaconAttachment);

    // TODO : fix path (see description)
    @DELETE("beacons/{beaconName}/attachments/{attachmentName}")
    Observable<Void> delete(@Path("beaconName") String beaconName, @Path("attachmentName") String attachmentName);


    // TODO : fix path (see description)
    @GET("beacons/{beaconName}/attachments?namespacedType=*/*")
    Observable<BeaconAttachmentList> list(@Path("beaconName") String beaconName);

    // TODO : fix path (see description)
    @GET("beacons/{beaconName}/attachments")
    Observable<BeaconAttachmentList> list(@Path("beaconName") String beaconName, @Query("namespacedType") String nameSpacedType);


}
