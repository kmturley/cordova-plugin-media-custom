# cordova-plugin-media-custom

A plugin for Cordova hybrid apps which allows custom overlays on the Camera. Based on the Camera2Video example by the Android team.

The following technologies are used in the app:
* Apache Cordova `http://cordova.apache.org/`
* Camera2Video `http://developer.android.com/samples/Camera2Video/index.html`

## Installation and running tasks

Install [Apache Cordova](http://cordova.apache.org/) then either navigate to a project or run the command:
    
First open an exisiting project or create a new project using:

    cordova create hello com.example.hello HelloWorld
    
Now navigate into the main directory and add this plugin using:

    cordova plugin add cordova-plugin-media-custom
    
Testing the plugin using plugman:

    npm install -g plugman
    plugman install --platform android --project www --plugin plugins/cordova-plugin-media-custom
    
Cordova caches plugins, So if you make any changes to a plugin's code you can force a reset using the following command:

    cordova platform remove android; cordova platform add android; cordova run android
    
Android Studio ignore camera output regex:

    ^(?!(mm-camera|Camera3-Device|Camera3-OutputStream|BufferQueueProducer))

## Directory Layout

    www/                --> Static html templates
      css/              --> Stylesheet files
      img/              --> Image files
      index.html        --> Homepage
      js/               --> Javascript functionality

## Contact

For more information please contact kmturley