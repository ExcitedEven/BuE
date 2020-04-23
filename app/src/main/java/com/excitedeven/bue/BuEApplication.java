package com.excitedeven.bue;

import android.app.Application;

import com.excitedeven.bue.bean.User;

public class BuEApplication extends Application {
    private User user;
    private static BuEApplication mInstance;

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
}
