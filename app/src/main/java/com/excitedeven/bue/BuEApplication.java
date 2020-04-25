package com.excitedeven.bue;

import android.app.Application;
import android.content.Context;
import android.content.Intent;

import com.excitedeven.bue.bean.User;

public class BuEApplication extends Application {
    private User user;
    private static BuEApplication mInstance;
    private Intent intent;
    private Context context;

    public static BuEApplication getInstance() {
        return mInstance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        mInstance = this;
    }

    public void initUser() {
        //TODO 从本地获取User
    }

    public User getUser() {
        return user;
    }

    public void clearUser() {
        this.user = null;
        //TODO 将本地的User也清除
    }

    public Intent getIntent() {
        return intent;
    }

    public void setIntent(Intent intent) {
        this.intent = intent;
    }

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }
}
