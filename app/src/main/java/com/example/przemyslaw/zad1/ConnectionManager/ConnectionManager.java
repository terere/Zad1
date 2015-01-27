package com.example.przemyslaw.zad1.ConnectionManager;

import com.squareup.okhttp.Call;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import java.io.IOException;

/**
 * Singleton class designed for handling communication between device and web service
 */
public class ConnectionManager {

    private static ConnectionManager mConnectionManager = null;

    /**
     * constructor
     */
    protected ConnectionManager() {

    }

    /**
     * Method create instance of this class
     *
     * @return return instance of class
     */
    public static ConnectionManager getConnectionManager() {
        if (mConnectionManager == null) {
            mConnectionManager = new ConnectionManager();
        }
        return mConnectionManager;
    }

    /**
     * Method return response code from service
     *
     * @param url url to service
     * @return return integer with response code
     * @throws IOException exception if communication occurred error
     */
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
