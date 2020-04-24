package com.excitedeven.bue.activity;

import android.content.Intent;

import com.excitedeven.bue.R;

public class TempActivity extends BaseActivity {
    @Override
    protected int getLayoutId() {
        return R.layout.fragment_all_orders;
    }

    @Override
    protected void init() {
        startActivity(new Intent(this, HomeActivity.class), false);
    }
}

