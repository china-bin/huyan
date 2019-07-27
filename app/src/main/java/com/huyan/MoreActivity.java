package com.huyan;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.huyan.more.AuthorActivity;
import com.huyan.more.ColorBlindActivity;
import com.huyan.more.CommonSenseActivity;

/**
 * @date: 2019/4/15
 * @author:bin
 * @email:958615915@qq.com
 */
public class MoreActivity extends AppCompatActivity {

    private ImageView iv_back;
    private RelativeLayout rl_author;
    private RelativeLayout rl_color_blind;
    private RelativeLayout rl_common_sense;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.more);
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
        rl_author.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MoreActivity.this, AuthorActivity.class);
                startActivity(intent);
            }
        });
        rl_color_blind.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MoreActivity.this, ColorBlindActivity.class);
                startActivity(intent);
            }
        });
        rl_common_sense.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MoreActivity.this, CommonSenseActivity.class);
                startActivity(intent);
            }
        });


    }

    private void initView() {
        iv_back = findViewById(R.id.iv_back);
        rl_author = findViewById(R.id.rl_item_author);
        rl_color_blind = findViewById(R.id.rl_item_color_blind);
        rl_common_sense = findViewById(R.id.rl_item_common_sense);
    }

    @Override
    public void finish() {
        super.finish();
        //  去掉activity 本身的动画
        overridePendingTransition(0, R.anim.out_from_right);
    }
}
