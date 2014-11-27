package com.bettycc.swipeactivity;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by ccheng on 11/26/14.
 */
public class BackgroundLabel extends View {

    public static final int FONT_SIZE_IN_DP = 14;
    private float mScrollThreshold;
    private float mFontSize;
    private Bitmap mBackIcon;

    public BackgroundLabel(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    private void init(Context context, AttributeSet attrs) {
        mScrollThreshold = context.getResources().getDimension(R.dimen.scroll_threshold);
        mFontSize = dp2px(FONT_SIZE_IN_DP);
        mBackIcon = BitmapFactory.decodeResource(getResources(), R.drawable.ic_arrow_back_grey600_24dp);
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.save();
        canvas.rotate(-90);
        canvas.translate(-getHeight()/2, mScrollThreshold/2 + mFontSize/2);
        TextPaint textPaint = new TextPaint();
        textPaint.setColor(Color.BLACK);
        textPaint.setTextSize(mFontSize);
//        canvas.drawCircle(0, 0, 60, textPaint);
        canvas.drawText("向右滑动", 0, 0, textPaint);
        canvas.drawBitmap(mBackIcon, mFontSize*4 + dp2px(12), -mBackIcon.getHeight() + dp2px(8), null);
        canvas.restore();
    }

    public float dp2px(float dp) {
        return getResources().getDisplayMetrics().density * dp;
    }
}
