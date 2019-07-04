package com.example.learningandroid;

import android.content.Context;
import android.widget.Toast;

public class AppUtils {

    /**
     * The method to show toast messages.
     *
     * @param context
     * @param message
     */
    public static void showToast(Context context, String message) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
    }
}