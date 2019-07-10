package com.hectest.hecfuelsdktest;

import android.content.Context;

public class TestClass {

    private static final String TAG = TestClass.class.getSimpleName();

    public static boolean testSDK(Context context){
        if (context == null)
            throw new RuntimeException();
        new TestClass2(context);
        return true;
    }

}
