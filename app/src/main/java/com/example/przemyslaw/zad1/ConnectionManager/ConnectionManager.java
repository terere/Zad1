package com.example.przemyslaw.zad1.ConnectionManager;

import com.squareup.okhttp.Call;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import java.io.IOException;

public class ConnectionManager {

    private static ConnectionManager mConnectionManager = null;

    protected ConnectionManager() {

    }

    public static ConnectionManager getConnectionManager() {
        if (mConnectionManager == null) {
            mConnectionManager = new ConnectionManager();
        }
        return mConnectionManager;
    }

    public int getResponseCode(String url) throws IOException {
        final OkHttpClient client = new OkHttpClient();

            Request request = new Request.Builder()
                    .url(url)
                    .build();

            Call call = client.newCall(request);
            Response response = call.execute();

            if (!response.isSuccessful()) {
                throw new IOException("Unexpected code " + response);
            }
        return response.code();
    }
}
