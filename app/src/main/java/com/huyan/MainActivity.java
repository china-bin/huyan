package com.huyan;

import android.animation.ObjectAnimator;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

import com.huyan.util.ObjectAnimatorUtil;
import com.huyan.util.TimeSharePrefrenceHelper;
import com.huyan.view.CircleView;

import java.util.Timer;
import java.util.TimerTask;

/**
*@date: 2019/4/12
*@author:bin
*@email:958615915@qq.com
*/
public class MainActivity extends AppCompatActivity {
    private SeekBar sb_b;
    private ImageView iv_main;
    private Dialog dialog;
    private CircleView cv_default, cv_yellow, cv_green, cv_red, cv_black;
    private TextView tv_change_title;
    private TextView tv_time;
    private ImageView iv_more;
    private UIHandler uiHandler;
    private CircleView[] cvArray = new CircleView[5];
    private String[] modeTitle = new String[]{
            "推荐色:轻度护眼模式",
            "黄色:适合双眼对蓝光刺激很敏感的用户",
            "绿色：适合白天使用，轻松不费眼",
            "红色：有效助眠，适宜晚8点后使用",
            "黑色：适合追剧党，游戏党"

    };
    private int currentMode = 5; // 初始化没有模式 ， 0推荐色，1黄色， 2绿色， 3红色， 4黑色
    //红蓝绿 三原色的初始值
    private int blue = 100;
    private int red = 100;
    private int green = 100;
    private int alapha = 100;

    private int blueProgress = 0;
    private int redProgress = 0;
    private int greenProgress = 0;
    private int alaphaProgress = 0;
    private TimeSharePrefrenceHelper timeSharePrefrenceHelper;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        initView();
        initData();
        openAleterWindow();

        initListner();
        initCirceViewListener();// 5种模式的切换
        statisticUseTime();

    }

    /**
     * 统计用户使用时长
     */
    public void statisticUseTime() {
        if (timeSharePrefrenceHelper == null) {
            timeSharePrefrenceHelper = new TimeSharePrefrenceHelper(this);
        }

        Timer timer =new Timer();
        timer.schedule(new TimerTask() {// 每一分钟执行一次
            @Override
            public void run() {
                int count = timeSharePrefrenceHelper.getCount();// 得到分钟数
                count += 1;
                timeSharePrefrenceHelper.setCount(count);
                Message m = new Message();
                m.what = CHANGE_TIME;
                Bundle bundle = new Bundle();
                bundle.putInt("count", count);
                m.setData(bundle);
                uiHandler.sendMessage(m);

            }
        }, 0, 1000*60);

    }

    private void initCirceViewListener() {
        cv_default.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                restoreCircle();// 复原以前的圆形
                ObjectAnimatorUtil.big(cv_default);
                currentMode = 0;
                setMode(modeTitle[currentMode], 100, 100, 40);
            }
        });
        cv_yellow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                restoreCircle();// 复原以前的圆形
                ObjectAnimatorUtil.big(cv_yellow);
                currentMode = 1;
                setMode(modeTitle[currentMode], 88, 73, 133);
            }
        });

        cv_green.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                restoreCircle();// 复原以前的圆形
                ObjectAnimatorUtil.big(cv_green);
                currentMode = 2;
                setMode(modeTitle[currentMode], 0, 100, 100);
            }
        });

        cv_red.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                restoreCircle();// 复原以前的圆形
                ObjectAnimatorUtil.big(cv_red);
                currentMode = 3;
                setMode(modeTitle[currentMode], 100, 0, 100);
            }
        });

        cv_black.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                restoreCircle();// 复原以前的圆形
                ObjectAnimatorUtil.big(cv_black);
                currentMode = 4;
                setMode(modeTitle[currentMode], 100, 100, 100);
            }
        });


    }

    /**
     * 切换模式
     * @param text
     * @param red
     * @param green
     * @param alapha
     */
    public void setMode(String text,int red, int green, int alapha){
        tv_change_title.setText(text);
        iv_main.setBackgroundColor(Color.argb(alapha, red, green, blue));
        this.red = red;
        this.green = green;
        this.alapha = alapha;
    }



    public void restoreCircle() {
        if (currentMode != 5) { //不是初始状态
            ObjectAnimatorUtil.restore(cvArray[currentMode]);
        }
    }

    private void initView() {
        sb_b = findViewById(R.id.sb_b);
        iv_more = findViewById(R.id.iv_more);

        tv_change_title = findViewById(R.id.tv_change_title);
        tv_time = findViewById(R.id.tv_time);
        cv_default = findViewById(R.id.cv_deefault);
        cv_yellow = findViewById(R.id.cv_yellow);
        cv_green = findViewById(R.id.cv_green);
        cv_red = findViewById(R.id.cv_red);
        cv_black = findViewById(R.id.cv_black);

        cvArray[0] = cv_default;
        cvArray[1] = cv_yellow;
        cvArray[2] = cv_green;
        cvArray[3] = cv_red;
        cvArray[4] = cv_black;
        uiHandler = new UIHandler();
    }

    private void initListner() {

        sb_b.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

                int add = progress-blueProgress;
                blue = blue-add;
                blueProgress = progress;
                Log.e("this","blue:"+blue);
                iv_main.setBackgroundColor(Color.argb(alapha,red,green,blue));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        iv_more.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, MoreActivity.class);
                startActivity(intent);
            }
        });

    }

    public  void initData(){    //每当打开acitivy 对 sharedprefernces 初始化
        SharedPreferences myPreference=getSharedPreferences("myPreference", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = myPreference.edit();
        editor.putInt("alapha",100);
        editor.putInt("red", 100);
        editor.putInt("blue", 100);
        editor.putInt("green", 100);

        editor.commit();

    }

    public void getData(){  //获取 存储 sharePrefrence 保存的三原色值
        SharedPreferences preferences = getSharedPreferences("myPreference", Context.MODE_PRIVATE);
        alapha = preferences.getInt("alapha",100);
        red = preferences.getInt("red",100);
        green = preferences.getInt("green",100);
        blue = preferences.getInt("blue",100);
        sb_b.setProgress(100-blue);
        iv_main.setBackgroundColor(Color.argb(alapha,red,green,blue));

    }

    public void saveData(){
        SharedPreferences myPreference = getSharedPreferences("myPreference", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = myPreference.edit();
        if(alapha >=0 && alapha <= 255 && red >= 0 && red <= 100 && blue >= 0 && blue <= 100 && green >= 0 && green <= 100) {
            editor.putInt("alapha", alapha);
            editor.putInt("red", red);
            editor.putInt("blue", blue);
            editor.putInt("green", green);
            editor.commit();
        }


    }


    private void openAleterWindow() {   //打开 dailog 窗口 对 dailog 初始化

        dialog=new Dialog(this,R.style.dialog_translucent);
        dialog.setContentView(R.layout.dialog);


        WindowManager.LayoutParams lp = dialog.getWindow().getAttributes();
        lp.width = WindowManager.LayoutParams.MATCH_PARENT;
        lp.height = WindowManager.LayoutParams.WRAP_CONTENT;
        lp.flags =WindowManager.LayoutParams.FLAG_NOT_TOUCH_MODAL |
                WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE | WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE;  //设置不影响下层的触碰
	    if (Build.VERSION.SDK_INT >= 26){
            lp.type = WindowManager.LayoutParams.TYPE_APPLICATION_OVERLAY;
        } else {
            lp.type = WindowManager.LayoutParams.TYPE_SYSTEM_OVERLAY;
        }

        
        dialog.getWindow().setAttributes(lp);

        dialog.show();



        iv_main=dialog.findViewById(R.id.ll_main);
        getData();

    }

    private static final int CHANGE_TIME = 1101;
    class UIHandler extends Handler {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what)  {
                case CHANGE_TIME:
                    Bundle bundle = msg.getData();
                    int count = bundle.getInt("count");
                    // 判断是否超过一小时
                    String text = "你今日使用";
                    if (count > 60) {
                       int hour = count / 60;
                       count = count - hour*60;
                       text += hour + "小时，" + count + "分钟";
                    } else {
                        text += count + "分钟";
                    }
                    tv_time.setText(text);

                break;

            }

        }
    }

}
