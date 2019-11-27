# cordova-plugin-media-custom

A plugin for Cordova hybrid apps which allows custom overlays on the Video Camera. Based on the Camera2Video example by the Android team, using:

* [Apache Cordova](http://cordova.apache.org/)
* [Android Camera2Video](https://github.com/android/camera-samples)


## Installation and running tasks

Install [Apache Cordova](http://cordova.apache.org/) then either navigate to a project or run the command:

First open an exisiting project or create a new project using:

    cordova create hello com.example.hello HelloWorld

Now navigate into the main directory and add this plugin using:

    cordova plugin add cordova-plugin-media-custom

Or use the command:

    cordova plugin add https://github.com/kmturley/cordova-plugin-media-custom.git

And use Javascript in your html page to call the plugin:

    window.MediaCustom.show(function (data) {
        window.alert('user recorded a video: ' + data);
        window.MediaCustom.hide();
    }, function () {
        window.alert('user clicked on the gallery button');
    });

Full example utilising the custom camera:

    <a href="#" class="button" id="open">Open Camera</a>
    <div class="video-container">
        <video src="assets/intro.mp4" id="video" autoplay controls></video>
    </div>
    <div id="output">
        <h2>Metadata</h2>
    </div>
    <script src="cordova.js"></script>
    <script>
        document.addEventListener('deviceready', function() {
            var video = document.getElementById('video'),
                output = document.getElementById('output');

            video.addEventListener('loadeddata', function (e) {
                // for some reason we need a delay to successfully retrieve metadata
                window.setTimeout(function () {
                    output.innerHTML += 'src = ' + e.target.src + '<br/>';
                    output.innerHTML += 'duration = ' + e.target.duration + '<br/>';
                    output.innerHTML += 'videoWidth = ' + e.target.videoWidth + '<br/>';
                    output.innerHTML += 'videoHeight = ' + e.target.videoHeight + '<br/>';
                }, 200);
            });

            document.getElementById('open').addEventListener('click', function () {
                if (window.MediaCustom) {
                    window.MediaCustom.show(function (data) {
                        video.src = data;
                        window.MediaCustom.hide();
                    }, function (e) {
                        //window.alert('MediaCustom.error: ' + JSON.stringify(e));
                        window.MediaCustom.hide();
                        navigator.camera.getPicture(function (data) {
                            //window.alert('getPicture.success: ' + JSON.stringify(data));
                            video.src = data;
                        }, function (e) {
                            window.alert('getPicture.error: ' + JSON.stringify(e));
                        }, {
                            sourceType: Camera.PictureSourceType.PHOTOLIBRARY,
                            mediaType: Camera.MediaType.VIDEO,
                            destinationType: Camera.DestinationType.FILE_URI
                        });
                    });
                } else {
                    window.alert('MediaCustom feature not supported');
                }
            });

            document.addEventListener('backbutton', function (e) {
                e.preventDefault();
                window.alert('back pressed');
            }, false);
        });
    </script>

Testing the plugin using plugman:

    npm install -g plugman
    plugman install --platform android --project www --plugin plugins/cordova-plugin-media-custom

Cordova caches plugins, So if you make any changes to a plugin's code you can force a reset using the following command:

    cordova platform remove android; cordova platform add android; cordova run android

Android Studio ignore camera output regex:

    ^(?!(mm-camera|Camera3-Device|Camera3-OutputStream|BufferQueueProducer))

Command to take a screenshot of a connected android device:

    adb shell screencap -p | perl -pe 's/\x0D\x0A/\x0A/g' > screen.png

Command to capture video from a connected android device screen:

    adb shell screenrecord --verbose /sdcard/ExampleName.mp4


## Directory Layout

    www/                --> Static html templates
      css/              --> Stylesheet files
      img/              --> Image files
      index.html        --> Homepage
      js/               --> Javascript functionality


## Contact

For more information please contact kmturley
