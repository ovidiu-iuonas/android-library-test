package com.hectest.hecfuelsdktest.package1;

import android.content.Context;

import com.hectest.hecfuelsdktest.package2.TestClass2;

public class TestClass {

    private static final String TAG = TestClass.class.getSimpleName();

    public static boolean testSDK(Context context){
        if (context == null)
            throw new RuntimeException();
        new TestClass2(context);
        return true;
    }

}
