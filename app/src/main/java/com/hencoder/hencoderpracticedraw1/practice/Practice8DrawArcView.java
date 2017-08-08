package com.hencoder.hencoderpracticedraw1.practice;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Build;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

public class Practice8DrawArcView extends View {

    Paint paint = new Paint();
    Paint paint1 = new Paint();

    public Practice8DrawArcView(Context context) {
        super(context);
    }

    public Practice8DrawArcView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice8DrawArcView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

//        练习内容：使用 canvas.drawArc() 方法画弧形和扇形
        //useCenter 是否连接圆心 true扇形 false 弧形
        paint.setStyle(Paint.Style.FILL);
        canvas.drawArc(200,100,800,500,-100,100,true,paint);
        canvas.drawArc(200,100,800,500,20,140,false,paint);

        paint1.setStyle(Paint.Style.STROKE);
        canvas.drawArc(200,100,800,500,180,60,false,paint1);

    }
}
