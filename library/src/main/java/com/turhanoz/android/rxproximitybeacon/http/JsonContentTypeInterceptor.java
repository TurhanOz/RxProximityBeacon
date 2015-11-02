package com.turhanoz.android.rxproximitybeacon.http;

import com.squareup.okhttp.Interceptor;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import java.io.IOException;

public class JsonContentTypeInterceptor implements Interceptor {
    @Override
    public Response intercept(Interceptor.Chain chain) throws IOException {
        Request request = chain.request();
        Request authorizationRequest = request.newBuilder()
                .addHeader("Content-Type", "application/json")
                .build();
        return chain.proceed(authorizationRequest);
    }
}
