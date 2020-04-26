package com.excitedeven.bue.activity;

import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.excitedeven.bue.BuEApplication;
import com.excitedeven.bue.R;
import com.excitedeven.bue.bean.User;

public class LoginActivity extends BaseActivity {

    private EditText mEtxtPhone;
    private EditText mEtxtPwd;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_login;
    }

    @Override
    protected void init() {
        mEtxtPhone = this.findViewById(R.id.etxt_phone);
        mEtxtPwd = this.findViewById(R.id.etxt_pwd);
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_login:
                login();
                break;
            case R.id.txt_toReg:
//                startActivity(new Intent(this, RegActivity.class));
                break;
        }
    }

    private void login() {
        String phone = mEtxtPhone.getText().toString().trim();
        if (TextUtils.isEmpty(phone)) {
            Toast.makeText(this, "请输入手机号", Toast.LENGTH_SHORT).show();
            return;
        }

        String pwd = mEtxtPwd.getText().toString().trim();
        if (TextUtils.isEmpty(pwd)) {
            Toast.makeText(this, "请输入密码", Toast.LENGTH_SHORT).show();
            return;
        }

        loginlogic(phone, pwd);
    }

    private void loginlogic(String phone, String pwd) {
        //TODO 与数据库比对进行登陆
        User user = new User();
        user.setUsername("Even");
        user.setId((long) 1);// 从数据库获取
        startActivity(BuEApplication.getInstance().getIntent(), false);
        finish();
    }

    @Override
    protected void onResume() {
        super.onResume();
        BuEApplication.getInstance().setContext(this);
    }
}
