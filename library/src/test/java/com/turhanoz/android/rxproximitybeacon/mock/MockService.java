package com.turhanoz.android.rxproximitybeacon.mock;

import com.turhanoz.android.rxproximitybeacon.util.ResourceUtils;

public class MockService {
    protected String getResponseAsString(String localResourceName) {
        String responseAsString = null;
        try {
            responseAsString = ResourceUtils.getStringFromAndroidResource(this, "/" + localResourceName);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return responseAsString;
    }
}
