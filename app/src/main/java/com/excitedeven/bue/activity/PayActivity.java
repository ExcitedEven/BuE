package com.excitedeven.bue.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.excitedeven.bue.R;

public class PayActivity extends BaseActivity {

    @Override
    protected int getLayoutId() {
        return R.layout.activity_pay;
    }

    @Override
    protected void init() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                finish();
                startActivity(new Intent(PayActivity.this, HomeActivity.class), false);
            }
        }, 1000);
    }
}
