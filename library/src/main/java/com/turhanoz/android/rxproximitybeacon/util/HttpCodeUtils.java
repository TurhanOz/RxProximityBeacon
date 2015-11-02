package com.turhanoz.android.rxproximitybeacon.util;


import retrofit.HttpException;

public class HttpCodeUtils {

    public static boolean isHttp401Error(Throwable throwable) {
        return isErrorCode(throwable, 401);
    }

    public static boolean isHttp400Error(Throwable throwable) {
        return isErrorCode(throwable, 400);
    }

    public static boolean isHttp409Error(Throwable throwable) {
        return isErrorCode(throwable, 409);
    }

    public static boolean isHttp404Error(Throwable throwable) {
        return isErrorCode(throwable, 404);
    }
    private static boolean isErrorCode(Throwable throwable, int code) {
        if (throwable instanceof HttpException) {
            HttpException httpException = (HttpException) throwable;
            return (httpException.code() == code);
        }
        return false;
    }


}
