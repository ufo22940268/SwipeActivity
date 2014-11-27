package com.bettycc.swipeactivity.library;

import android.app.Activity;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.ViewGroup;

import com.bettycc.swipactivity.library.R;


public class SwipeActivity extends Activity {

    private ViewGroup mContentView;
    private GestureDetector mGestureDetector;
    private TouchListener mTouchListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.setContentView(R.layout.swipe_root);
        mContentView = (ViewGroup)findViewById(R.id.swipe_activity);
        mTouchListener = new TouchListener(mContentView);
        mGestureDetector = new GestureDetector(this, mTouchListener);

        mTouchListener.setOnScrollEndListener(new TouchListener.OnScrollEndListener() {
            @Override
            public void onScrollToEnd() {
                finish();
                overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
            }
        });
    }

    public void setContentViewMod(int layoutResID) {
        getLayoutInflater().inflate(layoutResID, mContentView);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (event.getAction() == MotionEvent.ACTION_UP) {
            mTouchListener.onActionUp(event);
        }

        return mGestureDetector.onTouchEvent(event);
    }
}
