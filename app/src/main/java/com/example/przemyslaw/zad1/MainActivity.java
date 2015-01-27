package com.example.przemyslaw.zad1;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.widget.Toast;

import com.example.przemyslaw.zad1.Controllers.MainActivityController;
import com.example.przemyslaw.zad1.Interfaces.MainActivityInterface;
import com.example.przemyslaw.zad1.Utils.Utils;

import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Main view class
 */
public class MainActivity extends ActionBarActivity implements MainActivityInterface {

    private MainActivityController mMainActivityController;

    /**
     * Main method of application
     *
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.inject(this);
        mMainActivityController = new MainActivityController(this);
    }

    @OnClick(R.id.main_button)
    /**
     * Method realized after OnClick
     */
    public void connectWithWeb() {
        Utils.showInProgressDialog(MainActivity.this);
        mMainActivityController.establishConnection();
    }

    /**
     * Implemented method of interface for show success toast
     */
    @Override
    public void showSuccessToast() {
        Utils.hideInProgressDialog();
        Toast.makeText(MainActivity.this, getString(R.string.success_toast_message), Toast.LENGTH_SHORT).show();
    }

    /**
     * Implemented method of interface for show failure toast
     */
    @Override
    public void showFailureToast() {
        Utils.hideInProgressDialog();
        Toast.makeText(MainActivity.this, getString(R.string.failure_toast_message), Toast.LENGTH_SHORT).show();
    }
}
