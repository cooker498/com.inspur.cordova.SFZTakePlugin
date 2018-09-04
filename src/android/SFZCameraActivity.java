package com.inspur.cordova.SFZTakePlugin;

/**
 * Created by daijw on 2018/9/3.
 */

import android.Manifest;
import android.app.Activity;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.widget.Button;


public class SFZCameraActivity extends Activity {

    private Button button;
    private CameraSurfaceView mCameraSurfaceView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

//        requestWindowFeature(Window.FEATURE_NO_TITLE);
//        // 全屏显示
//        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(MResource.getIdByName(this, "layout", "activity_takesfz"));

        mCameraSurfaceView = (CameraSurfaceView) findViewById(MResource.getIdByName(this, "id", "cameraSurfaceView"));
        button = (Button) findViewById(MResource.getIdByName(this, "id", "takePic"));

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mCameraSurfaceView.takePicture(SFZCameraActivity.this);
            }
        });
    }




//    public void autoFocus() {
//        mCameraSurfaceView.setAutoFocus();
//    }
}