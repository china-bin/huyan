package com.huyan.util;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import java.io.InputStream;

/**
 * 加载assets 下面的图片
 * @date: 2019/4/24
 * @author:bin
 * @email:958615915@qq.com
 */

public class LoadAssetImgUtil {

    public static Bitmap getBitMap(Context context, String fileName) {
        InputStream inputStream = context.getClass().getClassLoader().getResourceAsStream("assets/" + fileName);
        return  InputStream2Bitmap(inputStream);
    }


    private static Bitmap InputStream2Bitmap(InputStream is) {
        return BitmapFactory.decodeStream(is);
    }
}
