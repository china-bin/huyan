package com.huyan.more;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import com.huyan.R;

/**
 * @date: 2019/4/16
 * @author:bin
 * @email:958615915@qq.com
 */
public class AuthorActivity extends AppCompatActivity {

    private ImageView iv_back;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.author);
        initView();
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

    private void initView() {
        iv_back = findViewById(R.id.iv_back);
    }

    @Override
    public void finish() {
        super.finish();
        overridePendingTransition(0, R.anim.out_from_right);
    }
}
