package com.hectest.hecfuelsdktest.package2;

import android.content.Context;
import android.util.Log;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.hectest.hecfuelsdktest.R;

public class TestClass2 {

    private static final String TAG = TestClass2.class.getSimpleName();

    public TestClass2(Context context){
        doTestRequest(context);
    }

    private void doTestRequest(Context context){
        RequestQueue queue = Volley.newRequestQueue(context);

        String testUrl = context.getResources().getString(R.string.url);

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
