/**
 * Media Custom Plugin - allows the user to have custom overlays
 * @class MediaCustom
 * @example 
 **/

/*globals require, module*/

var argscheck = require('cordova/argscheck'),
    exec = require('cordova/exec'),
    mediaCustomExport = {};

/**
 * Show camera
 * @param {Function} successCallback
 * @param {Function} errorCallback
 * @param {Object} options
 */
mediaCustomExport.show = function (successCallback, errorCallback, options) {
    'use strict';
    argscheck.checkArgs('fFO', 'MediaCustom.show', arguments);
    options = options || {};
    var getValue = argscheck.getValue,
        args = [getValue(options.option, 'option-default-value'), getValue(options.test, 3)];
    exec(successCallback, errorCallback, "MediaCustom", "show", args);
};


/**
 * Hide camera
 * @param {Function} successCallback
 * @param {Function} errorCallback
 * @param {Object} options
 */
mediaCustomExport.hide = function (successCallback, errorCallback, options) {
    'use strict';
    var args = [];
    exec(successCallback, errorCallback, "MediaCustom", "hide", args);
};

module.exports = mediaCustomExport;