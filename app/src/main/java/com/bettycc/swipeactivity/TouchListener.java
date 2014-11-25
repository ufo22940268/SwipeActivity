package com.bettycc.swipeactivity;

import android.animation.ObjectAnimator;
import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by ccheng on 11/25/14.
 */
class TouchListener extends GestureDetector.SimpleOnGestureListener {

    private static final float SCROLL_DIV = 3;
    private final Context mContext;
    private final float mScrollThres;
    private View mDecorView;
    private boolean mAnimate;

    TouchListener(View decorView) {
        mDecorView = decorView;
        mContext = mDecorView.getContext();
        mScrollThres = mContext.getResources().getDimension(R.dimen.scroll_threshold);
    }

    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    @Override
    public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
        float scrollX = mDecorView.getScrollX() - (e2.getX() - e1.getX());
        if (mAnimate) {
            return false;
        }

        scrollX /= SCROLL_DIV;

        if (scrollX > 0) {
            scrollX = 0;
        } else if (-scrollX > mScrollThres) {
            scrollX = -mScrollThres;
        }

        mDecorView.scrollTo((int) scrollX, 0);

        return true;
    }


    private void postScroll() {
        float scrollX = mDecorView.getScrollX();
        if (scrollX == -mScrollThres) {
            onScrollToEnd();
        } else {
            ObjectAnimator scrollXAnim = ObjectAnimator.ofInt(mDecorView, "scrollX", (int) scrollX, 0);
            scrollXAnim.setDuration(mContext.getResources().getInteger(android.R.integer.config_shortAnimTime));
            scrollXAnim.start();
        }
    }

    private void onScrollToEnd() {

    }

    public void onActionUp(MotionEvent e) {
        postScroll();
    }
}
