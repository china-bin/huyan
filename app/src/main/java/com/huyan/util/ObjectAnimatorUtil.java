package com.huyan.util;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.view.View;

/**
 * date:2019/4/12
 */
public class ObjectAnimatorUtil {

    /**
     *  对圆形放大
     */
    public static void big(View view) {
        ObjectAnimator bigX = ObjectAnimator.ofFloat(view, "scaleX", 1f, 1.5f);
        ObjectAnimator bigY = ObjectAnimator.ofFloat(view, "scaleY", 1f, 1.5f);

        bigX.start();
        bigY.start();
//        AnimatorSet animatorSet = new AnimatorSet();
//        animatorSet.play(bigX).with(bigY);
//        animatorSet.setDuration(1000);
//        animatorSet.start();

    }
    public static void restore(View view) {
        ObjectAnimator bigX = ObjectAnimator.ofFloat(view, "scaleX", 1.5f, 1f);
        ObjectAnimator bigY = ObjectAnimator.ofFloat(view, "scaleY", 1.5f, 1f);

        bigX.start();
        bigY.start();

    }

}
