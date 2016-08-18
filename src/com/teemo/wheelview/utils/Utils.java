/**
 * 
 */
package com.teemo.wheelview.utils;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.WindowManager;

import com.teemo.wheelview.common.ConstantUtils;

/**
 * @author WuXinPing
 *
 */
public class Utils {
    private static Utils sInstance;

    private Utils() {}

    public static Utils getInstance() {
        if (sInstance == null) {
            sInstance = new Utils();
        }
        return sInstance;
    }

    /**
     * 获屏幕高度/像素
     * 
     * @param mContext
     *            上下文对象
     * @return 屏幕高度
     */
    public static int getScreenHeightPx(Context mContext) {
        try {
            WindowManager manager = (WindowManager) mContext.getSystemService(Context.WINDOW_SERVICE);
            DisplayMetrics dm = new DisplayMetrics();
            manager.getDefaultDisplay().getMetrics(dm);
            return dm.heightPixels;
        } catch (Exception e) {
            return 0;
        }
    }

    /**
     * 获屏幕宽度/像素
     * 
     * @param mContext
     *            上下文对象
     * @return 屏幕宽度
     */
    public static int getScreenWidthPx(Context mContext) {
        try {
            WindowManager manager = (WindowManager) mContext.getSystemService(Context.WINDOW_SERVICE);
            DisplayMetrics dm = new DisplayMetrics();
            manager.getDefaultDisplay().getMetrics(dm);
            return dm.widthPixels;
        } catch (Exception e) {
            return 0;
        }
    }

    /*****
     * @brief 获取屏幕的像素密度
     */
    public static float getScreenDensity(Context mContext) {
        WindowManager manager = (WindowManager) mContext.getSystemService(Context.WINDOW_SERVICE);
        DisplayMetrics dm = new DisplayMetrics();
        manager.getDefaultDisplay().getMetrics(dm);
        return dm.density;
    }

    public static SimpleDateFormat getDateFormat(String formatTime) {
        SimpleDateFormat format = new SimpleDateFormat(formatTime);
        return format;
    }

    public static DecimalFormat getDecimalFormat(String pattern) {
        DecimalFormat format2 = new DecimalFormat("#0.00");
        return format2;
    }

    /**
     * 根据手机的分辨率从 dp 的单位 转成为 px(像素)
     */
    public int dp2px(Context context, float dpValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }

    /**
     * @brief 获取年集合
     *
     * @return
     * ArrayList<String>
     */
    public ArrayList<String> getYearList() {
        ArrayList<String> years = new ArrayList<String>(Arrays.asList(ConstantUtils.KeyList.SCENE_TIME_YEAR_ARRY));
        return years;
    }

    /**
     * @brief 获取月集合
     *
     * @return
     * ArrayList<String>
     */
    public ArrayList<String> getMonthList() {
        ArrayList<String> month = new ArrayList<String>(Arrays.asList(ConstantUtils.KeyList.SCENE_TIME_MONTH_ARRY));
        return month;
    }

    /**
     * @brief 获取日集合
     *
     * @return
     * ArrayList<String>
     */
    public ArrayList<String> getDayList() {
        ArrayList<String> days = new ArrayList<String>(Arrays.asList(ConstantUtils.KeyList.SCENE_TIME_DAY_ARRY));
        return days;
    }

    /**
     * @brief 获取小时集合
     *
     * @return
     * ArrayList<String>
     */
    public ArrayList<String> getHourList() {
        ArrayList<String> hours = new ArrayList<String>(Arrays.asList(ConstantUtils.KeyList.SCENE_TIME_HOUR_ARRY));
        return hours;
    }

    /**
     * @brief 获取分钟集合
     *
     * @return
     * ArrayList<String>
     */
    public ArrayList<String> getMinuteList() {
        ArrayList<String> minus = new ArrayList<String>(Arrays.asList(ConstantUtils.KeyList.SCENE_TIME_MINUTE_ARRY));
        return minus;
    }

    
}
