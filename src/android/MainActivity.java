package com.example.android.camera2video;

import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaWebView;
import org.apache.cordova.LOG;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.*;
import java.lang.*;

import android.app.Fragment;
import android.content.Context;
import android.content.res.Resources;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;

public class MainActivity extends CordovaActivity {
    
    private static final String TAG = "MainActivity";
    
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onBackPressed() {
        Log.e(TAG, "onBackPressed");
    }
}