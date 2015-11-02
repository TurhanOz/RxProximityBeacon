package com.turhanoz.android.rxproximitybeacon.http;

import com.squareup.okhttp.OkHttpClient;
import com.turhanoz.android.rxproximitybeacon.BeaconInfoService;
import com.turhanoz.android.rxproximitybeacon.BeaconsAttachmentService;
import com.turhanoz.android.rxproximitybeacon.BeaconsDiagnosticsService;
import com.turhanoz.android.rxproximitybeacon.BeaconsService;
import com.turhanoz.android.rxproximitybeacon.NamespacesService;

import retrofit.GsonConverterFactory;
import retrofit.Retrofit;
import retrofit.RxJavaCallAdapterFactory;

public class RetrofitClient {
    public static final String ENDPOINT = "https://proximitybeacon.googleapis.com/v1beta1/";
    public static final String SCOPE = "oauth2:https://www.googleapis.com/auth/userlocation.beacon.registry";

    BeaconInfoService infoService;
    BeaconsAttachmentService attachmentService;
    BeaconsDiagnosticsService diagnosticsService;
    BeaconsService beaconsService;
    NamespacesService namespacesService;

    OkHttpClient client;
    String token;
    Retrofit retrofit;

    public RetrofitClient(String token) {
        this.token = token;

        initOkHttpClient(token);
        initRetrofit();
        initService();
    }

    private void initOkHttpClient(String token) {
        client = new OkHttpClient();
        client.interceptors().add(new AuthorizationInterceptor(token));
        client.interceptors().add(new JsonContentTypeInterceptor());
//        if (BuildConfig.DEBUG) {
            HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
            httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
            client.interceptors().add(httpLoggingInterceptor);
//        }

        //TODO : client.setAuthenticator(http://lgvalle.xyz/2015/07/27/okhttp-authentication/)
    }

    private void initRetrofit() {
        retrofit = new Retrofit.Builder()
                .baseUrl(ENDPOINT)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .client(client)

                .build();
    }

    private void initService() {

        infoService = retrofit.create(BeaconInfoService.class);
        attachmentService = retrofit.create(BeaconsAttachmentService.class);
        diagnosticsService = retrofit.create(BeaconsDiagnosticsService.class);
        beaconsService = retrofit.create(BeaconsService.class);
        namespacesService = retrofit.create(NamespacesService.class);
    }

    public BeaconInfoService getInfoService() {
        return infoService;
    }

    public BeaconsAttachmentService getAttachmentService() {
        return attachmentService;
    }

    public BeaconsDiagnosticsService getDiagnosticsService() {
        return diagnosticsService;
    }

    public BeaconsService getBeaconsService() {
        return beaconsService;
    }

    public NamespacesService getNamespacesService() {
        return namespacesService;
    }
}
