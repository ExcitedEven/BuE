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

    /**
     * 判断跳转时是否应该先登陆
     * @param intent 将会传入BuEApplication, 成功登陆后再取出进行跳转
     * @param isNeedLogin 判断是否需要跳转的flag
     */
    public void startActivity(Intent intent, boolean isNeedLogin) {

        if (isNeedLogin) {
            if (BuEApplication.getInstance().getUser() != null) {
                super.startActivity(intent);
            } else {
                /**
                 * 将intent传入BuEApplication实例
                 * 之后可以调用其getIntent()方法进行获取
                 */
                BuEApplication.getInstance().setIntent(intent);
                Intent loginIntent = new Intent(this, LoginActivity.class);
                super.startActivity(loginIntent);
            }
        } else {
            super.startActivity(intent);
        }
    }
}
