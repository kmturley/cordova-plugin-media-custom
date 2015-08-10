/*
 * Copyright 2014 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.android.camera2video;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.Log;

import org.apache.cordova.CordovaInterface;

public class CameraActivity extends Activity {
    
    private static CordovaInterface cordova;
    private static Context context;
    private static Resources resources;
    private static String packageName;
    
    private static final String TAG = "CameraActivity";
    
    public CameraActivity(CordovaInterface cordovaInstance) {
		cordova = cordovaInstance;
        context = cordova.getActivity().getApplicationContext();
        resources = context.getResources();                       
        packageName = context.getPackageName();

        cordova.getActivity().runOnUiThread(new Runnable() {
             @Override
             public void run() {
                cordova.getActivity().setContentView(resources.getIdentifier("activity_camera", "layout", packageName));
                cordova.getActivity().getFragmentManager().beginTransaction().replace(resources.getIdentifier("container", "id", packageName), Camera2VideoFragment.newInstance(cordova)).commit();
            }
        });
	}
}