package com.bettycc.swipeactivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

/**
 * Created by ccheng on 11/27/14.
 */
public class FirstActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
    }

    public void launch(View view) {
        startActivity(new Intent(this, SecondActivity.class));
        overridePendingTransition(R.anim.slide_in_right, R.anim. slide_out_left);
    }
}
