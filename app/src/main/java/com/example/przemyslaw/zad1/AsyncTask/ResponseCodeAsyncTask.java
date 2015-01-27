package com.example.przemyslaw.zad1.AsyncTask;

import android.os.AsyncTask;

import com.example.przemyslaw.zad1.ConnectionManager.ConnectionManager;
import com.example.przemyslaw.zad1.Interfaces.ResponseCodeInterface;

import java.io.IOException;

public class ResponseCodeAsyncTask extends AsyncTask<String, Void, Integer> {

    private ResponseCodeInterface mResponseCodeInterface;

    public ResponseCodeAsyncTask(ResponseCodeInterface mResponseCodeInterface) {
        this.mResponseCodeInterface = mResponseCodeInterface;
    }

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

    @Override
    protected void onPostExecute(Integer responseCode) {
        super.onPostExecute(responseCode);
        mResponseCodeInterface.responseCode(responseCode);
    }
}
