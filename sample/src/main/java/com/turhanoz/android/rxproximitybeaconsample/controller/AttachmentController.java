package com.turhanoz.android.rxproximitybeaconsample.controller;

import android.util.Log;

import com.turhanoz.android.rxproximitybeacon.BeaconsAttachmentService;
import com.turhanoz.android.rxproximitybeacon.model.BeaconAttachment;
import com.turhanoz.android.rxproximitybeacon.model.DeletedAttachmentsCount;
import com.turhanoz.android.rxproximitybeacon.model.BeaconAttachmentList;
import com.turhanoz.android.rxproximitybeacon.util.EncodeUtils;

import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class AttachmentController {
    BeaconsAttachmentService attachmentService;

    public AttachmentController(BeaconsAttachmentService attachmentService) {
        this.attachmentService = attachmentService;
    }

    public void runSequences(String sanitizedBeaconName) {
        //Bear in mind all these are asynchronous, so could be executed in various order;
        //So last instruction (batchDeleted) could be filled
        createAttachment(sanitizedBeaconName);
        createAttachment(sanitizedBeaconName);
        createAttachment(sanitizedBeaconName);

        batchDeleteAttachments(sanitizedBeaconName);
    }

    public void listAttachments(String sanitizedBeaconName) {
        String nameSpacedType = "*/*";
        attachmentService.list(sanitizedBeaconName, nameSpacedType)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .unsubscribeOn(Schedulers.newThread())
                .subscribe(new Observer<BeaconAttachmentList>() {
                    @Override
                    public void onCompleted() {
                        Log.d("LIST-ATTACHMENTS", "onComplete");
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.d("LIST-ATTACHMENTS", "onError: " + e.toString());
                    }

                    @Override
                    public void onNext(BeaconAttachmentList beaconAttachmentList) {
                        Log.d("LIST-ATTACHMENTS", "onNext" + beaconAttachmentList.toString());
                    }
                });
    }

    public void deleteAttachment(String sanitizedBeaconName, String sanitizedAttachmentName) {
        attachmentService.delete(sanitizedBeaconName, sanitizedAttachmentName)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .unsubscribeOn(Schedulers.newThread())
                .subscribe(new Observer<Void>() {
                    @Override
                    public void onCompleted() {
                        Log.d("DELETE-ATTACHMENT", "onComplete");
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.d("DELETE-ATTACHMENT", "onError :" + e.toString());
                    }

                    @Override
                    public void onNext(Void aVoid) {
                        Log.d("DELETE-ATTACHMENT", "onNext : " + aVoid);
                    }
                });

    }

    public void createAttachment(String sanitizedBeaconName) {
        BeaconAttachment attachment = new BeaconAttachment("", "beacons-1073/offer", EncodeUtils.base64Encode("50% off".getBytes()));
        attachmentService.create(sanitizedBeaconName, attachment)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .unsubscribeOn(Schedulers.newThread())
                .subscribe(new Observer<BeaconAttachment>() {
                    @Override
                    public void onCompleted() {
                        Log.d("CREATE-ATTACHMENT", "onComplete");
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.d("CREATE-ATTACHMENT", "onError :" + e.toString());
                    }

                    @Override
                    public void onNext(BeaconAttachment beaconAttachment) {
                        Log.d("CREATE-ATTACHMENT", "onNext : " + beaconAttachment.toString());
                    }
                });
    }

    public void batchDeleteAttachments(String sanitizedBeaconName) {
        attachmentService.batchDelete(sanitizedBeaconName)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .unsubscribeOn(Schedulers.newThread())
                .subscribe(new Observer<DeletedAttachmentsCount>() {
                    @Override
                    public void onCompleted() {
                        Log.d("BATCHDELETE", "onComplete");
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.d("BATCHDELETE", "onError :" + e.toString());
                    }

                    @Override
                    public void onNext(DeletedAttachmentsCount count) {
                        Log.d("BATCHDELETE", "onNext : deleted count : " + count);
                    }
                });
    }
}
