package com.example.przemyslaw.zad1.Controllers;

import com.example.przemyslaw.zad1.ConnectionManager.ConnectionManager;
import com.example.przemyslaw.zad1.Interfaces.MainActivityInterface;
import com.example.przemyslaw.zad1.Utils.Const;
import com.squareup.okhttp.Callback;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import java.io.IOException;

import static java.net.HttpURLConnection.HTTP_OK;

public class MainActivityController {

    private MainActivityInterface mMainActivityInterface;

    public MainActivityController(MainActivityInterface mMainActivityInterface) {
        this.mMainActivityInterface = mMainActivityInterface;
    }

    public void establishConnection() {
        ConnectionManager.getmConnectionManager().getResponseCode(Const.MOBICA_URL, new Callback() {
            @Override
            public void onFailure(Request request, IOException e) {
                //TODO implements correct error handling
                mMainActivityInterface.showFailureToast();
            }

            @Override
            public void onResponse(Response response) throws IOException {
                if (!response.isSuccessful()) {
                    mMainActivityInterface.showFailureToast();
                    throw new IOException("Unexpected code " + response);
                }
                onWebResponse(response);
            }
        });
    }

    private void onWebResponse(Response response) {
        switch (response.code()) {
            case HTTP_OK:
                mMainActivityInterface.showSuccessToast();
                break;
            default:
                mMainActivityInterface.showFailureToast();
                break;
        }
    }


}
