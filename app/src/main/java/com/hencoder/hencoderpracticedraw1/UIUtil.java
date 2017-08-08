package com.hencoder.hencoderpracticedraw1;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.WindowManager;

/**
 * Created by xianghongyan on 2017/8/8.
 */


public class UIUtil {

    /**
     * 获取手机屏幕分辨率 DisplayMetrics
     * @param context
     * @return
     */
    public static final DisplayMetrics getDisplayMetrics(Context context){
        WindowManager windowManager = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        DisplayMetrics displayMetrics = new DisplayMetrics();
        windowManager.getDefaultDisplay().getMetrics(displayMetrics);
        return displayMetrics;
    }

    /**
     * 获取手机屏幕分辨率 宽度 单位px
     * @param context
     * @return
     */
    public static final int getScreenWidth(Context context){

        DisplayMetrics displayMetrics = new DisplayMetrics();
        return displayMetrics.widthPixels;
    }

    /**
     * TypedValue.applyDimension 参数1 要转换的单位，参数2 要转换的单位的值，参数3 返回有效的度量
     * dp转换为px
     * @param dp
     * @return
     */
    public static final int dp2Px(float dp){
        Resources resources = Resources.getSystem();
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, resources.getDisplayMetrics());
    }

    /**
     *
     * @param sp
     * @return
     */
    public static final int sp2Px(float sp){
        Resources resources = Resources.getSystem();
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, sp, resources.getDisplayMetrics());
    }
}
