package com.huyan.view;


import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import com.huyan.R;

/**
 * date:2019/4/12
 */
public class CircleView extends View {

    private Paint paint;// 画笔
    private int color;// 颜色

    public CircleView(Context context) {
        super(context);
    }

    public CircleView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);

    }

    public CircleView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.CircleView, defStyleAttr, 0);
        color = typedArray.getColor(R.styleable.CircleView_color, color);
        Log.e("this", color+":color");

    }

    private void init() {
        paint = new Paint();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        paint.setColor(color);
        paint.setStyle(Paint.Style.FILL);// 设置画笔实心
        canvas.drawCircle(getWidth()/2, getWidth()/2, getWidth()/2, paint);

    }
}
