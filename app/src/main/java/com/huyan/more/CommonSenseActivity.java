package com.huyan.more;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import com.huyan.R;
import com.huyan.adapter.CommonSenseAdapter;
import com.huyan.bean.CommonSense;
import com.huyan.util.DataUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * @date: 2019/4/26
 * @author:bin
 * @email:958615915@qq.com
 */

/**
 * 护眼小常识
 */
public class CommonSenseActivity extends AppCompatActivity {

    private ListView lv;
    private List<CommonSense> datas;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.common_sense);
        initView();
        initData();
        initAdapter();
    }

    private void initAdapter() {
        CommonSenseAdapter commonSenseAdapter = new CommonSenseAdapter(this, datas);
        lv.setAdapter(commonSenseAdapter);
    }

    private void initData() {
        datas.addAll(DataUtil.getCommonSense());
    }

    private void initView() {
        datas = new ArrayList<CommonSense>();
        lv = findViewById(R.id.lv);
    }

}
