package com.hectest.hecfuelsdktest;

import android.content.Context;
import android.util.Log;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

public class TestClass {

    private static final String TAG = TestClass.class.getSimpleName();

    public static boolean testSDK(Context context){
        if (context == null)
            throw new RuntimeException();
        doTestRequest(context);
        return true;
    }

    private static void doTestRequest(Context context){
        RequestQueue queue = Volley.newRequestQueue(context);

        String testUrl = "https://google.com";

        Log.i(TAG, "The test request will be made.");

        StringRequest authorizeCardRequest = new StringRequest
                (Request.Method.GET, testUrl, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Log.i(TAG, response);
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.e(TAG, "Request error ", error);
                    }
                }) {};

        authorizeCardRequest.setRetryPolicy(new DefaultRetryPolicy(30000, 0, 0));

        queue.add(authorizeCardRequest);
    }

}
