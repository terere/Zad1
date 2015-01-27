package com.example.przemyslaw.zad1.AsyncTask;

import android.os.AsyncTask;

import com.example.przemyslaw.zad1.ConnectionManager.ConnectionManager;
import com.example.przemyslaw.zad1.Interfaces.ResponseCodeInterface;

import java.io.IOException;

/**
 * ResponseCodeAsyncTask.java
 * Class created to establish connection between device and service and collect
 * result of this connection.
 *
 * Major function of this AsyncTask is collect information about response
 * code
 */
public class ResponseCodeAsyncTask extends AsyncTask<String, Void, Integer> {

    private ResponseCodeInterface mResponseCodeInterface;

    /**
     * Constructor of class.
     *
     * @param mResponseCodeInterface interface for return value to activity
     */
    public ResponseCodeAsyncTask(ResponseCodeInterface mResponseCodeInterface) {
        this.mResponseCodeInterface = mResponseCodeInterface;
    }

    /**
     * doInBackground try to get response code from service
     *
     * @param url url to web service
     * @return return response code
     */
    @Override
    protected Integer doInBackground(String... url) {
        int responseCode = 0;
        try {
            responseCode = ConnectionManager.getConnectionManager()
                    .getResponseCode(url[0]);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return responseCode;
    }

    /**
     * onPostExecute publish response code by interface
     *
     * @param responseCode int with response code
     */
    @Override
    protected void onPostExecute(Integer responseCode) {
        super.onPostExecute(responseCode);
        mResponseCodeInterface.responseCode(responseCode);
    }
}
