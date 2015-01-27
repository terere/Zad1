package com.example.przemyslaw.zad1.Controllers;

import com.example.przemyslaw.zad1.AsyncTask.ResponseCodeAsyncTask;
import com.example.przemyslaw.zad1.Interfaces.MainActivityInterface;
import com.example.przemyslaw.zad1.Interfaces.ResponseCodeInterface;
import com.example.przemyslaw.zad1.Utils.Const;

import static java.net.HttpURLConnection.HTTP_OK;

public class MainActivityController implements ResponseCodeInterface{

    private MainActivityInterface mMainActivityInterface;

    public MainActivityController(MainActivityInterface mMainActivityInterface) {
        this.mMainActivityInterface = mMainActivityInterface;
    }

    public void establishConnection() {
        new ResponseCodeAsyncTask(this).execute(Const.MOBICA_URL);
    }

    @Override
    public void responseCode(Integer responseCode) {
        switch (responseCode) {
            case HTTP_OK:
                mMainActivityInterface.showSuccessToast();
                break;
            default:
                mMainActivityInterface.showFailureToast();
                break;
        }
    }
}
