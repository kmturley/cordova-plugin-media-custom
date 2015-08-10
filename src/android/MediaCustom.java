package com.example.android.camera2video;

import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CallbackContext;
import org.apache.cordova.LOG;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.*;
import java.lang.*;

import android.content.Context;
import android.content.res.Resources;
import android.util.Log;

/**
 * MediaCustom
 * Custom Camera Overlays
 */
public class MediaCustom extends CordovaPlugin {
    
    private static CameraActivity cameraactivity;
    private static final String TAG = "MediaCustom";

    @Override
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {

        Log.d(TAG, "execute: " + action);
        if (action.equals("example")) {
            cameraactivity = new CameraActivity(cordova);
            return true;
        }
        return false;
    }
}