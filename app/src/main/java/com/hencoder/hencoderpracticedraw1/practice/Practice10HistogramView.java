package com.hencoder.hencoderpracticedraw1.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.hencoder.hencoderpracticedraw1.UIUtil;

public class Practice10HistogramView extends View {

    Paint paint1 = new Paint();
    Paint paint2 = new Paint();
    Paint paint3 = new Paint();
    Path path = new Path();


    public Practice10HistogramView(Context context) {
        super(context);
    }

    public Practice10HistogramView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice10HistogramView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

//        综合练习
//        练习内容：使用各种 Canvas.drawXXX() 方法画直方图
        paint1.setStyle(Paint.Style.STROKE);
        paint1.setStrokeWidth(2);
        paint1.setColor(Color.WHITE);

        paint2.setStyle(Paint.Style.FILL);
        paint2.setColor(Color.GREEN);

        int screenWidth = UIUtil.getScreenWidth(getContext());
        int height = getHeight();

        /**
         * 绘制坐标系,左右各留出30dp的空间
         * 来自源码 @param pts      Array of points to draw [x0 y0 x1 y1 x2 y2 ...]
         */
        float[] pts = {UIUtil.dp2Px(30),UIUtil.dp2Px(30),UIUtil.dp2Px(30),height-UIUtil.dp2Px(60),UIUtil.dp2Px(30),
                height-UIUtil.dp2Px(60),screenWidth-UIUtil.dp2Px(30),height-UIUtil.dp2Px(60)};
        canvas.drawLines(pts,paint1);

        /**
         * Rect 为矩形保留四个坐标
         *绘制长方形
         * 设置宽度，间隔
         */
        int interval = UIUtil.dp2Px(5);
        int singleWidth = (screenWidth-UIUtil.dp2Px(30)*2-interval*8) /7;
        for (int i = 0; i < 7; i++) {
            Rect rect = new Rect();
            rect.left = UIUtil.dp2Px(30) + (i+1)*interval + i*singleWidth;
            rect.top = rect.bottom - (i+1)*UIUtil.dp2Px(10);
            rect.right = rect.left+singleWidth;
            rect.bottom = UIUtil.dp2Px(60);

            canvas.drawRect(rect,paint2);
        }


        /**
         * getTextBounds 文本边界
         * 绘制文字
         * drawText 在（x，y）处绘制文字
         */
        Rect textBound = new Rect();
        paint3.setTextSize(UIUtil.sp2Px(12));
        String[] texts = {"Froyo", "GB", "IC S", "JB", "KitKat", "L", "M"};
        paint3.setColor(Color.WHITE);
        for (int i = 0; i < 7; i++) {
            String text = texts[i];
            paint3.getTextBounds(text,0,text.length(),textBound);
            canvas.drawText(text,UIUtil.dp2Px(30)+(i+1)*interval+i*singleWidth+(singleWidth-textBound.width())/2,
                    height-UIUtil.dp2Px(60),paint3);
        }
    }
}

