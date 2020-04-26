package com.excitedeven.bue.activity;

import android.content.Intent;
import android.os.Handler;

import com.excitedeven.bue.BuEApplication;
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
                //TODO 跳转订单页面
                Intent intent = new Intent(PayActivity.this, HomeActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                intent.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
                startActivity(intent, false);
            }
        }, 1000);
    }

    @Override
    protected void onResume() {
        super.onResume();
        BuEApplication.getInstance().setContext(this);
    }
}
