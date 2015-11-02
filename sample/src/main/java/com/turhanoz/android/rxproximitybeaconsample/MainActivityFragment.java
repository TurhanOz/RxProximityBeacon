package com.turhanoz.android.rxproximitybeaconsample;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.turhanoz.android.rxproximitybeacon.http.RetrofitClient;
import com.turhanoz.android.rxproximitybeaconsample.controller.AttachmentController;
import com.turhanoz.android.rxproximitybeaconsample.controller.BeaconController;
import com.turhanoz.android.rxproximitybeaconsample.controller.BeaconInfoController;
import com.turhanoz.android.rxproximitybeaconsample.controller.DiagnosticController;
import com.turhanoz.android.rxproximitybeaconsample.controller.NameSpaceController;


public class MainActivityFragment extends Fragment {
    String oauth2Token = "GET TOKEN IN SOME WAY (using GoogleAuthUtils or RxGoogleAuthentication)";
    String apiKey = "GET API KEY FROM GOOGLE DEVELOPER CONSOLE";
    String sanitizedBeaconName = "3!SOME BEAON ID YOU OWN";

    RetrofitClient client;
    AttachmentController attachmentController;
    NameSpaceController nameSpaceController;
    DiagnosticController diagnosticController;
    BeaconInfoController beaconInfoController;
    BeaconController beaconController;


    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_main, container, false);
        initService();

        //Uncomment to use services below


        nameSpaceController = new NameSpaceController(client.getNamespacesService());
        // nameSpaceController.runSequence();

        attachmentController = new AttachmentController(client.getAttachmentService());
        // attachmentController.runSequences(sanitizedBeaconName);

        diagnosticController = new DiagnosticController(client.getDiagnosticsService());
        // diagnosticController.runSequence(sanitizedBeaconName);

        beaconInfoController = new BeaconInfoController(client.getInfoService(), apiKey);
        // beaconInfoController.runSequence(advertisedIdString, nameSpace);

        beaconController = new BeaconController(client.getBeaconsService());
        // beaconController.runSequence(sanitizedBeaconName);

        return rootView;
    }

    private void initService() {
        client = new RetrofitClient(oauth2Token);
    }
}
