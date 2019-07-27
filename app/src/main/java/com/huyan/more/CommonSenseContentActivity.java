package com.huyan.more;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import com.huyan.R;

/**
 * @date: 2019/4/26
 * @author:bin
 * @email:958615915@qq.com
 */
public class CommonSenseContentActivity extends AppCompatActivity {
    private String title;
    private String content;
    private TextView tv_title;
    private TextView tv_content;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.common_sense_content);
        initView();
        getmIntnent();
        initSurface();
    }

    private void initView() {
        tv_title = findViewById(R.id.tv_title);
        tv_content = findViewById(R.id.tv_contnet);
    }


    private void initSurface() {
        tv_title.setText(title);
        tv_content.setText(content);
    }

    private void getmIntnent() {
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        content = bundle.getString("content");
        title = bundle.getString("title");
    }
}
