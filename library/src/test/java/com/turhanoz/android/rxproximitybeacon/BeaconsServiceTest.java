package com.turhanoz.android.rxproximitybeacon;

import com.turhanoz.android.rxproximitybeacon.mock.MockBeaconService;
import com.turhanoz.android.rxproximitybeacon.model.ListBeacons;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricGradleTestRunner;
import org.robolectric.annotation.Config;

import java.util.concurrent.TimeUnit;

import retrofit.mock.MockRetrofit;
import retrofit.mock.NetworkBehavior;
import retrofit.mock.RxJavaBehaviorAdapter;
import rx.Observer;
import rx.schedulers.Schedulers;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

@RunWith(RobolectricGradleTestRunner.class)
@Config(constants = BuildConfig.class, sdk = 21)
//inspired from https://github.com/square/retrofit/blob/master/samples/src/main/java/com/example/retrofit/SimpleMockService.java
public class BeaconsServiceTest {
    //Retrofit retrofit = new Retrofit.Builder().baseUrl(BeaconsService.ENDPOINT).build();
    NetworkBehavior networkBehavior;
    MockRetrofit mockRetrofit;
    BeaconsService sut;

    @Before
    public void setUp() throws Exception {
        configureNetworkBehaviour();
        mockRetrofit = new MockRetrofit(networkBehavior, RxJavaBehaviorAdapter.create());
        sut = mockRetrofit.create(BeaconsService.class, new MockBeaconService());
    }

    private void configureNetworkBehaviour() {
        networkBehavior = NetworkBehavior.create();
        networkBehavior.setFailurePercent(0);
        networkBehavior.setDelay(0, TimeUnit.MILLISECONDS);
        networkBehavior.setVariancePercent(0);
    }

    @Test
    public void shouldGet() throws Exception {
        Observer<ListBeacons> mockObserver = mock(Observer.class);

        sut.list("status:active")
                .subscribeOn(Schedulers.trampoline())
                .observeOn(Schedulers.trampoline())
                .subscribe(mockObserver);

        verify(mockObserver).onNext(any(ListBeacons.class));
        verify(mockObserver).onCompleted();
    }
}