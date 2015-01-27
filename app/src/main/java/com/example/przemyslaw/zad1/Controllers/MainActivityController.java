package com.example.przemyslaw.zad1.Controllers;

import com.example.przemyslaw.zad1.AsyncTask.ResponseCodeAsyncTask;
import com.example.przemyslaw.zad1.Interfaces.MainActivityInterface;
import com.example.przemyslaw.zad1.Interfaces.ResponseCodeInterface;
import com.example.przemyslaw.zad1.Utils.Const;

import static java.net.HttpURLConnection.HTTP_OK;

/**
 * Controller for main activity class
 */
public class MainActivityController implements ResponseCodeInterface{

    private MainActivityInterface mMainActivityInterface;

    /**
     * Constructor
     *
     * @param mMainActivityInterface MainActivityInterface needed to communicate with view
     */
    public MainActivityController(MainActivityInterface mMainActivityInterface) {
        this.mMainActivityInterface = mMainActivityInterface;
    }

    /**
     * Method create async task to get response code from server
     */
    public void establishConnection() {
        new ResponseCodeAsyncTask(this).execute(Const.MOBICA_URL);
    }

    /**
     * Method of ResponseCodeInterface
     *
     * Major function is interpret result of async task
     *
     * @param responseCode integer with response code
     */
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
