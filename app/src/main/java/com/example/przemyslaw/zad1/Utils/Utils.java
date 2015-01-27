package com.example.przemyslaw.zad1.Utils;

import android.app.Activity;
import android.app.ProgressDialog;

import com.example.przemyslaw.zad1.R;

public class Utils {

    private static ProgressDialog mProgressDialog;

    public static void showInProgressDialog(Activity act) {
        if (mProgressDialog == null) {
            mProgressDialog = new ProgressDialog(act);
            mProgressDialog.setTitle(act.getString(R.string.progress_dialog_title));
        }
        mProgressDialog.show();
    }

    public static void hideInProgressDialog() {
        if (mProgressDialog != null) {
            mProgressDialog.hide();
        }
    }
}
