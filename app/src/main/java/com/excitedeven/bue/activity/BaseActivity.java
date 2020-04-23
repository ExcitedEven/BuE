package com.excitedeven.bue.activity;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.excitedeven.bue.BuEApplication;

public abstract class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        init();
    }

    protected abstract int getLayoutId();

    protected abstract void init();

    public void startActivity(Intent intent, boolean isNeedLogin) {

        if (isNeedLogin) {
            if (BuEApplication.getInstance().getUser() != null) {
                super.startActivity(intent);
            } else {
                //TODO 跳转到Login进行登陆
                Intent loginIntent = new Intent(this, LoginActivity.class);
                super.startActivity(loginIntent);
            }
        } else {
            super.startActivity(intent);
        }
    }
}
