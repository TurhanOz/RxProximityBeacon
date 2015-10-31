package com.turhanoz.android.rxproximitybeacon.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class ResourceUtils {

    //Store file under resources folder, such as resources/result.json
    public static String getStringFromAndroidResource(Object object, String resourceIdentifier) throws IOException {
        InputStream in = object.getClass().getResourceAsStream(resourceIdentifier);
        BufferedReader r = new BufferedReader(new InputStreamReader(in));
        StringBuilder total = new StringBuilder();
        String line;

        while ((line = r.readLine()) != null) {
            total.append(line);
        }

        return total.toString();
    }
}
