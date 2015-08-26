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
import android.view.View;

/**
 * MediaCustom
 * Custom Camera Overlays
 */
public class MediaCustom extends CordovaPlugin {

    private static final String TAG = "MediaCustom";
    
    private static Context context;
    private static Resources resources;
    private static String packageName;
    private static CallbackContext callback;

    @Override
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
        context = cordova.getActivity().getApplicationContext();
        resources = context.getResources();                       
        packageName = context.getPackageName();
        callback = callbackContext;

        Log.d(TAG, "action: " + action);
        
        if (action.equals("show")) {
            show();
            return true;
        } else if (action.equals("hide")) {
            hide();
            return true;
        } else {
            //callbackContext.success(exitVal);
            //callbackContext.error(e.getMessage());
            return false;
        }
    }
    
    // show the plugin
    public void show () {
        cordova.getActivity().runOnUiThread(new Runnable() {
             @Override
             public void run() {
                cordova.getActivity().setContentView(resources.getIdentifier("activity_camera", "layout", packageName));
                cordova.getActivity().getFragmentManager().beginTransaction().replace(resources.getIdentifier("container", "id", packageName), Camera2VideoFragment.newInstance(cordova, callback)).commit();
            }
        });
    }
    
    // hide the plugin
    public void hide () {
        cordova.getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Fragment fragment = cordova.getActivity().getFragmentManager().findFragmentById(resources.getIdentifier("container", "id", packageName));
                cordova.getActivity().getFragmentManager().beginTransaction().remove(fragment).commit();
                cordova.getActivity().setContentView(getView());
            }
        });
    }
    
    // override the back button behaviuor
    public void onBackPressed () {
        hide();
    }
    
    // Helper to be compile-time compatible with both Cordova 3.x and 4.x.
    private View getView() {
        try {
            return (View)webView.getClass().getMethod("getView").invoke(webView);
        } catch (Exception e) {
            return (View)webView;
        }
    }
}