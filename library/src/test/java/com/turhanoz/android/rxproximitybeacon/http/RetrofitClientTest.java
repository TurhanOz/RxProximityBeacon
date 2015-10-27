package com.turhanoz.android.rxproximitybeacon.http;

import com.turhanoz.android.rxproximitybeacon.BuildConfig;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricGradleTestRunner;
import org.robolectric.annotation.Config;

import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

@RunWith(RobolectricGradleTestRunner.class)
@Config(constants = BuildConfig.class, sdk = 21)
public class RetrofitClientTest {
    String token = "token123";
    RetrofitClient sut;

    @Before
    public void setUp() throws Exception {
        sut = new RetrofitClient(token);
    }

    @Test
    public void shouldCollaborateWithAuthorizationInterception() throws Exception {
        AuthorizationInterceptor expectedInterceptor = new AuthorizationInterceptor(token);

        assertSame(sut.client, sut.retrofit.client());
        assertTrue(sut.client.interceptors().contains(expectedInterceptor));
    }
}