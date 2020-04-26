package com.excitedeven.bue.activity;

import android.content.Intent;

import com.excitedeven.bue.BuEApplication;
import com.excitedeven.bue.R;

public class TempActivity extends BaseActivity {
    @Override
    protected int getLayoutId() {
        return R.layout.activity_home;
    }

    @Override
    protected void init() {
        startActivity(new Intent(this, HomeActivity.class), false);
        finish();
    }

    @Override
    protected void onResume() {
        super.onResume();
        BuEApplication.getInstance().setContext(this);
    }
}

