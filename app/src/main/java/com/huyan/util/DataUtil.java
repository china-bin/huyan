package com.huyan.util;

import com.huyan.bean.ColorBlind;
import com.huyan.bean.CommonSense;

import java.util.ArrayList;
import java.util.List;

/**
 * @date: 2019/4/24
 * @author:bin
 * @email:958615915@qq.com
 */
public class DataUtil {

    public static List<ColorBlind> getColorBlind() {
        List<ColorBlind> datas = new ArrayList<ColorBlind>();
        ColorBlind colorBlind = new ColorBlind(
            "1.jpg", "图中的数字为?", "2,6,26", "您可能为绿色色盲,您可能为红色色盲,恭喜你回答正确");
        datas.add(colorBlind);

        ColorBlind colorBlind2 = new ColorBlind(
            "2.jpg", "图中的动物为?", "牛,鹿", "恭喜你回答正确,您可能是色弱");
        datas.add(colorBlind2);

        ColorBlind colorBlind3 = new ColorBlind(
                "3.jpg", "图中的数字为?", "6,5,无数字", "恭喜你回答正确,您可能是绿色弱,您可能是全色弱");
        datas.add(colorBlind3);

        ColorBlind colorBlind4 = new ColorBlind(
                "4.jpg", "图中的数字为?", "5,无数字", "您可能是色盲,恭喜你回答正确");
        datas.add(colorBlind4);

        return datas;
    }

    public static List<CommonSense> getCommonSense() {
        List<CommonSense> datas = new ArrayList<CommonSense>();
        CommonSense commonSense = new CommonSense("科学用眼护眼常识", "适当的阅读距离：30厘米或以上。定时给眼睛作适当休息。在光线足够的环境下阅读及工作。不要在移动环境下阅读。适当的看电视电脑距离：电视屏幕的尺寸6倍或以上。保证充足的睡眠，合理的饮食及适当的锻炼。");
        datas.add(commonSense);
        return datas;
    }

}
