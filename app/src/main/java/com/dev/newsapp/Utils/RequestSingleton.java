package com.dev.newsapp.Utils;

import android.content.Context;
import android.util.Log;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

public class RequestSingleton {

    private static  RequestSingleton requestSingleton = null;
    private RequestQueue requestQueue;

    private RequestSingleton(Context context)
    {
        requestQueue = Volley.newRequestQueue(context.getApplicationContext());
    }

    public static synchronized RequestSingleton getRequestSingleton(Context context)
    {
        if(requestSingleton == null)
        {
            Log.d("singletonClass", "requestSingle is null [call only first time in full app] ");
            requestSingleton = new RequestSingleton(context);
        }
        else
        {
            Log.d("singletonClass", "requestSingle is not null [ unnecessary else part ] ");
        }
        return requestSingleton;
    }

    public RequestQueue getRequestQueue()
    {
        return requestQueue;
    }
}
