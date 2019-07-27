package com.huyan;

import android.animation.AnimatorSet;
import android.content.Intent;
import android.os.Build;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;

import java.util.Timer;
import java.util.TimerTask;

/**
*@date: 2019/4/12
*@author:bin
*@email:958615915@qq.com
*/
public class StartActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.start);

        Boolean flag = permission();// 动态注册悬浮窗权限

        if (flag) {
            // 定时跳转 MainActivity
            Timer timer = new Timer();
            TimerTask timerTask = new TimerTask() {
                @Override
                public void run() {
                    startActivity();
                    finish();
                }
            };
            timer.schedule(timerTask, 1000 * 2);//两秒之后跳转

        }


    }

    /**
     * 当正在进行动态注册权限时，返回false，不允许跳转到 mainActivity
     * @return
     */
    public Boolean permission() {
        if (Build.VERSION.SDK_INT >= 23) {
            if (!Settings.canDrawOverlays(this)) {
                Intent intent = new Intent(Settings.ACTION_MANAGE_OVERLAY_PERMISSION);
                startActivity(intent);
                return false;
            } else {
                return true;
            }
        }
        return true;
    }

    public void startActivity() {
        Intent intent = new Intent(StartActivity.this, MainActivity.class);
        startActivity(intent);
        finish();
    }


}
