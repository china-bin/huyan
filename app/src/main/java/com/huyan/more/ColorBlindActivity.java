package com.huyan.more;

import android.app.Dialog;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.huyan.R;
import com.huyan.bean.ColorBlind;
import com.huyan.util.DataUtil;
import com.huyan.util.LoadAssetImgUtil;

import java.sql.Time;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

/**
 * @date: 2019/4/24
 * @author:bin
 * @email:958615915@qq.com
 */
public class ColorBlindActivity extends AppCompatActivity {
    private ImageView iv;
    private TextView tv_question;
    private RadioGroup rg;// 选择答案的radio组
    private List<ColorBlind> datas;
    private int currentIndex = 0;// 当前问题的下标
    private ImageView iv_back;

    private Dialog dialog;
    private TextView tv_title;

    private UIHandler mUIhandler;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.color_blind);
        initView();
        initData();
        initSurface();// 初始化界面
        initListner();

    }

    private void initListner() {
        iv_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    private void initSurface() {
        // 设置单选框组
        String[] options = datas.get(currentIndex).getOption().split(",");
        final String[] infos = datas.get(currentIndex).getInfo().split(",");

        rg.removeAllViews();
        for (int i = 0; i < options.length; i++) {
            final RadioButton radioButton = new RadioButton(this);
            radioButton.setText(options[i]);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);

            // 选择选项弹窗
            final int finalI = i;
            radioButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    openDailog(infos[finalI]);
                }
            });
            rg.addView(radioButton, i, layoutParams);
        }

        tv_question.setText(datas.get(currentIndex).getQuestion());

        Bitmap bitmap = LoadAssetImgUtil.getBitMap(this, datas.get(currentIndex).getImg());
        iv.setImageBitmap(bitmap);
    }

    private void initData() {
        datas = new ArrayList<ColorBlind>();
        datas.addAll(DataUtil.getColorBlind());

    }
    private void openDailog(String text) {
        if (dialog == null) {
            dialog = new Dialog(this, R.style.dialog_translucent);
            dialog.setContentView(R.layout.dialog_color_blind);
            tv_title = dialog.findViewById(R.id.tv_title);
        }
        tv_title.setText(text);
        dialog.show();

        Timer timer = new Timer();
        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                closeDialog();
                // 进行下一个问题，如果还有问题 更新界面
                if (currentIndex < datas.size() - 1) {
                    currentIndex++;
                    Message m = new Message();
                    m.what = UPDATE_SURFACE;
                    mUIhandler.sendMessage(m);
                } else {
                    finish();
                }
            }
        };
        timer.schedule(timerTask, 2000);

    }
    private void closeDialog() {
        dialog.dismiss();;
    }


    private void initView() {
        iv = findViewById(R.id.iv);
        tv_question = findViewById(R.id.tv_question);
        rg = findViewById(R.id.rg);
        mUIhandler = new UIHandler();
        iv_back = findViewById(R.id.iv_back);
    }

    private static final int UPDATE_SURFACE = 1001;// 更新界面

    class UIHandler extends Handler {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case UPDATE_SURFACE:
                    initSurface();
                break;
            }
        }
    }

}
