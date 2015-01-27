package com.example.przemyslaw.zad1.Utils;

import android.app.Activity;
import android.app.ProgressDialog;

import com.example.przemyslaw.zad1.R;

/**
 * Class contains utils
 */
public class Utils {

    private static ProgressDialog mProgressDialog;

    /**
     * Method show progress dialog
     *
     * @param act activity
     */
    public static void showInProgressDialog(Activity act) {
        if (mProgressDialog == null) {
            mProgressDialog = new ProgressDialog(act);
            mProgressDialog.setTitle(act.getString(R.string.progress_dialog_title));
        }
        mProgressDialog.show();
    }

    /**
     * Method hide progress bar
     */
    public static void hideInProgressDialog() {
        if (mProgressDialog != null) {
            mProgressDialog.hide();
        }
    }
}
