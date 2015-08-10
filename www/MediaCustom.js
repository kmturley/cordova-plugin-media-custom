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
 * Example function
 * @param {Function} successCallback
 * @param {Function} errorCallback
 * @param {Object} options
 */
mediaCustomExport.example = function (successCallback, errorCallback, options) {
    'use strict';
    argscheck.checkArgs('fFO', 'MediaCustom.example', arguments);
    options = options || {};
    var getValue = argscheck.getValue,
        args = [getValue(options.option, 'option-default-value'), getValue(options.test, 3)];
    exec(successCallback, errorCallback, "MediaCustom", "example", args);
};

module.exports = mediaCustomExport;