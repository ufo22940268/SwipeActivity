package com.bettycc.swipeactivity;

import android.os.Bundle;

import com.bettycc.swipeactivity.library.SwipeActivity;

/**
 * Created by ccheng on 11/26/14.
 */
public class SecondActivity extends SwipeActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentViewMod(R.layout.activity_main);
    }
}
