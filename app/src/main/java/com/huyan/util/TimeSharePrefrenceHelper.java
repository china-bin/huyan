package com.huyan.util;

import android.content.Context;
import android.content.SharedPreferences;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
*@date: 2019/4/15
*@author:bin
*@email:958615915@qq.com
*/
public class TimeSharePrefrenceHelper {
    private Context context;
    public TimeSharePrefrenceHelper(Context context) {
        this.context = context;
    }

    public void setCount(int count) {
        SharedPreferences myPreference=context.getSharedPreferences("time", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = myPreference.edit();
        editor.putInt(getYMD(), count);
        editor.commit();
    }

    public int getCount() {
        SharedPreferences myPreference=context.getSharedPreferences("time", Context.MODE_PRIVATE);
        int count = myPreference.getInt(getYMD(), 0);
        return count;
    }

    /**
     * 获取年月日
     * @return
     */
    public String getYMD() {
        Date date = new Date();
        String year = String.format("%tY", date);
        String month = String.format("%tB", date);
        String day = String.format("%td", date);
        return year + month + day;
    }

}
