package com.example.przemyslaw.zad1.ConnectionManager;

import com.squareup.okhttp.Call;
import com.squareup.okhttp.Callback;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;

public class ConnectionManager {

    private static ConnectionManager mConnectionManager = null;

    protected ConnectionManager() {

    }

    public static ConnectionManager getmConnectionManager() {
        if (mConnectionManager == null) {
            mConnectionManager = new ConnectionManager();
        }
        return mConnectionManager;
    }

    public void getResponseCode(String url, Callback mCallback){
        final OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url(url)
                .build();

        Call call = client.newCall(request);
        call.enqueue(mCallback);
    }
}
