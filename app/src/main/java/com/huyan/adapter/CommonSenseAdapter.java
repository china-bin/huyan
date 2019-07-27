package com.huyan.adapter;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.huyan.R;
import com.huyan.bean.CommonSense;
import com.huyan.more.CommonSenseActivity;
import com.huyan.more.CommonSenseContentActivity;

import java.util.List;

/**
 * @date: 2019/4/26
 * @author:bin
 * @email:958615915@qq.com
 */
public class CommonSenseAdapter extends BaseAdapter {
    private Context context;
    private List<CommonSense> datas;

    public CommonSenseAdapter(Context context, List<CommonSense> datas){
        this.context = context;
        this.datas = datas;
    }

    @Override
    public int getCount() {
        return datas.size();
    }

    @Override
    public Object getItem(int i) {
        return datas.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(final int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder;// 将view 保存在内存中 减少了每次findViewByid的时间
        if (view == null) {
            view=View.inflate(context,R.layout.common_sense_item,null);
            view.setOnClickListener(new View.OnClickListener(){

                @Override
                public void onClick(View v) {
                    sendIntent(datas.get(i));
                }
            });
            viewHolder = new ViewHolder();
            viewHolder.tv_title = view.findViewById(R.id.tv_title);

            view.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) view.getTag();
        }
        CommonSense commonSense = (CommonSense) getItem(i);
        viewHolder.tv_title.setText(commonSense.getTitle());
        Log.e("this", "adapter running" + commonSense.getTitle());
        return view;
    }

    private void sendIntent(CommonSense commonSense) {
        Intent intent=new Intent(context, CommonSenseContentActivity.class);
        intent.putExtra("content", commonSense.getContent());
        intent.putExtra("title", commonSense.getTitle());
        context.startActivity(intent);
    }

    class ViewHolder {
        TextView tv_title;
    }
}
