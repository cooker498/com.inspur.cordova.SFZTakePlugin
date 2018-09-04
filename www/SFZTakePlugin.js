var exec = require('cordova/exec');

exports.coolMethod = function (arg0, success, error) {
    exec(success, error, 'SFZTakePlugin', 'coolMethod', [arg0]);
};



function SFZTakePlugin() {
}

SFZTakePlugin.prototype.takephoto = function (successCallback, errorCallback) {
    exec(successCallback, errorCallback, "SFZTakePlugin", "takephoto", []);
};



module.exports = new SFZTakePlugin();