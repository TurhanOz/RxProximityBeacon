package com.turhanoz.android.rxproximitybeacon.http;

import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import com.squareup.okhttp.mockwebserver.MockResponse;
import com.squareup.okhttp.mockwebserver.MockWebServer;
import com.turhanoz.android.rxproximitybeacon.BuildConfig;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricGradleTestRunner;
import org.robolectric.annotation.Config;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

//inspired from https://github.com/square/okhttp/blob/master/okhttp-tests/src/test/java/com/squareup/okhttp/InterceptorTest.java
@RunWith(RobolectricGradleTestRunner.class)
@Config(constants = BuildConfig.class, sdk = 21)
public class AuthorizationInterceptorTest {
    @Rule public MockWebServer server = new MockWebServer();
    String token = "tokenRandom99";
    OkHttpClient client;
    AuthorizationInterceptor sut;

    @Before
    public void setUp() throws Exception {
        sut = new AuthorizationInterceptor(token);
        client = new OkHttpClient();
        server.enqueue(new MockResponse());
    }

    @Test
    public void shouldIncludeAuthorizationHeader() throws Exception {
        client.interceptors().add(sut);

        Request request = new Request.Builder().url(server.url("/")).build();
        Response response = client.newCall(request).execute();

        assertNotNull(response.request().header("Authorization"));
        assertEquals("Bearer " + token, response.request().header("Authorization"));
    }

}