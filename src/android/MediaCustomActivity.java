package com.example.android.camera2video;

import org.apache.cordova.CordovaActivity;

import java.io.*;
import java.lang.*;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Window;
import android.view.WindowManager;

public class MediaCustomActivity extends CordovaActivity {

    public static void start(Activity activity) {
        Intent intent = new Intent(activity, MediaCustomActivity.class);
        activity.startActivity(intent);
    }

    public static void stop(Activity activity) {
        // what can we do here?
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.init();

        Window window = this.getWindow();
        window.setFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE, WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            return false;
        }
        return super.onKeyDown(keyCode, event);
    }
}