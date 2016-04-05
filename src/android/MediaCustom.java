package com.example.android.camera2video;

import com.example.android.camera2video.MediaCustomActivity;

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
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;

/**
 * MediaCustom
 * Custom Camera Overlays
 */
public class MediaCustom extends CordovaPlugin {

    public CallbackContext callbackContext;
    private static final String TAG = "MediaCustom";

    private static Context context;
    private static Resources resources;
    private static String packageName;
    private Fragment cameraFragment;

    @Override
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
        this.callbackContext = callbackContext;

        context = cordova.getActivity().getApplicationContext();
        resources = context.getResources();
        packageName = context.getPackageName();

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

    public void show() {
        if (cameraFragment != null) {
            return;
        }
        cameraFragment = Camera2VideoFragment.newInstance(cordova, callbackContext);
        cordova.getActivity().runOnUiThread(new Runnable() {
             @Override
             public void run() {
                cordova.getActivity().setContentView(resources.getIdentifier("activity_camera", "layout", packageName));
                FragmentManager fragmentManager = cordova.getActivity().getFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(resources.getIdentifier("container", "id", packageName), cameraFragment);
                fragmentTransaction.commit();

                MediaCustomActivity.start(cordova.getActivity());
            }
        });
    }

    public void hide() {
        if (cameraFragment == null) {
            return;
        }
        cordova.getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                MediaCustomActivity.stop(cordova.getActivity());

                cordova.getActivity().setContentView(getView());
                FragmentManager fragmentManager = cordova.getActivity().getFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.remove(cameraFragment);
                fragmentTransaction.commitAllowingStateLoss(); // commit();
                cameraFragment = null;
            }
        });
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