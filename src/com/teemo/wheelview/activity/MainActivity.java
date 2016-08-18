package com.teemo.wheelview.activity;

import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;

import com.teemo.wheelview.OnWheelScrollListener;
import com.teemo.wheelview.R;
import com.teemo.wheelview.WheelItemAdapter;
import com.teemo.wheelview.WheelView;
import com.teemo.wheelview.utils.Utils;

public class MainActivity extends Activity {
    private final String TAG = MainActivity.class.getSimpleName();
    public static final int TO_SENCE_SET_WEEK_SAVE_BUTTON = 3;
    public static final String IS_SET_WEEK_KEY = "IS_SET_WEEK_KEY";
    public static final String WEEK_VALUE = "WEEK_VALUE";

    private Context mContext;

    private String mStartHourStr = "00";
    private String mStartMinuteStr = "00";
    private String mEndHourStr = "00";
    private String mEndMinuteStr = "00";

    private WheelView mStartHourWheel;
    private WheelView mStartMinuteWheel;
    private WheelView mEndHourWheel;
    private WheelView mEndMinuteWheel;

    private List<String> mHourData = null;
    private List<String> mMinusData = null;

    @Override
    protected void onCreate(Bundle arg0) {
        super.onCreate(arg0);
        setContentView(R.layout.activity_main);
        getDataFromParent();
    }

    private void getDataFromParent() {
        mContext = this;

        initView();
    }

    private void initView() {

        mStartHourWheel = (WheelView) this.findViewById(R.id.scene_time_start_hour);
        mStartMinuteWheel = (WheelView) this.findViewById(R.id.scene_time_start_minute);
        mEndHourWheel = (WheelView) this.findViewById(R.id.scene_time_end_hour);
        mEndMinuteWheel = (WheelView) this.findViewById(R.id.scene_time_end_minute);

        mHourData = Utils.getInstance().getHourList();
        mMinusData = Utils.getInstance().getMinuteList();

        mStartHourWheel.setViewAdapter(new WheelItemAdapter(mContext, mHourData));
        mStartHourWheel.setCurrentItem(0);
        mStartHourWheel.addScrollingListener(mStartHourScrolledListener);
        mStartHourWheel.setCyclic(true);

        // mStartMinusAdapter = new WheelItemAdapter(mContext, mMinusData);
        mStartMinuteWheel.setViewAdapter(new WheelItemAdapter(mContext, mMinusData));
        mStartMinuteWheel.setCurrentItem(0);
        mStartMinuteWheel.addScrollingListener(mStartMinuteScrolledListener);
        mStartMinuteWheel.setCyclic(true);

        mEndHourWheel.setViewAdapter(new WheelItemAdapter(mContext, mHourData));
        mEndHourWheel.setCurrentItem(0);
        mEndHourWheel.addScrollingListener(mEndHourScrolledListener);
        mEndHourWheel.setCyclic(true);

        mEndMinuteWheel.setViewAdapter(new WheelItemAdapter(mContext, mMinusData));
        mEndMinuteWheel.setCurrentItem(0);
        mEndMinuteWheel.addScrollingListener(mEndMinuteScrolledListener);
        mEndMinuteWheel.setCyclic(true);

    }

    private void setCurrTime() {
        if (!mStartHourIsScroll && !mStartMinuIsScroll && !mEndHourIsScroll && !mEndMinuIsScroll) {
            mStartHourStr = mHourData.get(mStartHourWheel.getCurrentItem());
            mStartMinuteStr = mMinusData.get(mStartMinuteWheel.getCurrentItem());
            mEndHourStr = mHourData.get(mEndHourWheel.getCurrentItem());
            mEndMinuteStr = mMinusData.get(mEndMinuteWheel.getCurrentItem());
            Log.d(TAG, "mStartHourStr = " + mStartHourStr + " >>>>>> mStartMinuteStr = " + mStartMinuteStr + " >>>>>> mEndHourStr = " + mEndHourStr
                    + " >>>>>> mEndMinuteStr = " + mEndMinuteStr);
        }
    }

    private boolean mStartHourIsScroll = false;
    private boolean mStartMinuIsScroll = false;
    private boolean mEndHourIsScroll = false;
    private boolean mEndMinuIsScroll = false;

    private OnWheelScrollListener mStartHourScrolledListener = new OnWheelScrollListener() {

        @Override
        public void onScrollingStarted(WheelView wheel) {
            mStartHourIsScroll = true;
        }

        @Override
        public void onScrollingFinished(WheelView wheel) {
            mStartHourIsScroll = false;
            setCurrTime();
        }
    };

    private OnWheelScrollListener mStartMinuteScrolledListener = new OnWheelScrollListener() {

        @Override
        public void onScrollingStarted(WheelView wheel) {
            mStartMinuIsScroll = true;
        }

        @Override
        public void onScrollingFinished(WheelView wheel) {
            mStartMinuIsScroll = false;
            setCurrTime();
        }
    };

    private OnWheelScrollListener mEndHourScrolledListener = new OnWheelScrollListener() {

        @Override
        public void onScrollingStarted(WheelView wheel) {
            mEndHourIsScroll = true;
        }

        @Override
        public void onScrollingFinished(WheelView wheel) {
            mEndHourIsScroll = false;
            setCurrTime();
        }
    };

    private OnWheelScrollListener mEndMinuteScrolledListener = new OnWheelScrollListener() {

        @Override
        public void onScrollingStarted(WheelView wheel) {
            mEndMinuIsScroll = true;
        }

        @Override
        public void onScrollingFinished(WheelView wheel) {
            mEndMinuIsScroll = false;
            setCurrTime();
        }
    };
}
