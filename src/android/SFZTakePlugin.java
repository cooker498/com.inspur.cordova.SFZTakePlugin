package com.inspur.cordova.SFZTakePlugin;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.ExposedJsApi;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


/**
 * Created by daijw on 2018/9/4.
 */

public class SFZTakePlugin extends CordovaPlugin {
    private static final String TAG = "SFZTakePlugin";
    private CallbackContext context;
    private JSONObject jo = new JSONObject();
    private static final int REQUEST_EXTERNAL_STORAGE = 1;
    private static String[] PERMISSIONS_STORAGE = {
        Manifest.permission.READ_EXTERNAL_STORAGE,
        Manifest.permission.WRITE_EXTERNAL_STORAGE };
    private static String[] PERMISSIONS_CAMERA = {
        Manifest.permission.CAMERA,};

    @Override
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
        this.context = callbackContext;
        if (action.equals("takephoto")) {
            if (!cordova.hasPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE)) {
                cordova.requestPermissions(this, REQUEST_EXTERNAL_STORAGE, PERMISSIONS_STORAGE);
            }
            else if (!cordova.hasPermission(Manifest.permission.CAMERA)) {
                cordova.requestPermissions(this, REQUEST_EXTERNAL_STORAGE, PERMISSIONS_CAMERA);
            } else {
                Intent intent = new Intent(cordova.getActivity(),SFZCameraActivity.class);
                this.cordova.startActivityForResult(this, intent, 0);
            }
        }
        return true;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent intent) {
        // 根据resultCode判断处理结果
        try {
            if (resultCode == Activity.RESULT_OK) {
                jo.put("filePath", String.valueOf(intent.getStringExtra("filePath")));
                context.success(jo);
            } else if (resultCode == Activity.RESULT_CANCELED) {
                context.error("获取照片失败");
            }
        } catch (Exception e) {
            e.printStackTrace();
            context.error("获取照片失败");
        }
    }

}
