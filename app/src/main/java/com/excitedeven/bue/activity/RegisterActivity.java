package com.excitedeven.bue.activity;

import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.excitedeven.bue.BuEApplication;
import com.excitedeven.bue.R;
import com.excitedeven.bue.bean.User;

public class RegisterActivity extends BaseActivity {

    private User user = BuEApplication.getInstance().getUser();
    private ImageView regimg;
    private EditText regName;
    private EditText regAdder;
    private EditText regPhone;
    private Button regButton;
    private EditText regPwd;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_register;
    }

    @Override
    protected void init() {
        regimg = findViewById(R.id.img_reg);
        regName = findViewById(R.id.edt_reg_name);
        regAdder = findViewById(R.id.edt_reg_adder);
        regPwd = findViewById(R.id.edt_reg_pwd);
        regButton = findViewById(R.id.btn_reg);
        regPhone = findViewById(R.id.edt_reg_phone);

        /**
         * 如果User不为空, 说明是修改信息
         */
        if (user != null) {
            //TODO Image
            regimg.setImageResource(R.drawable.ic_launcher_foreground);
            regName.setText(user.getUsername());
            regAdder.setText(user.getAdder());
            regPwd.setText(user.getPwd());
            regPhone.setText(user.getPhone());

            regButton.setText("修改");
        } else {
            regButton.setText("注册");
        }

        regButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                reg(true);
            }
        });
    }

    private void reg(boolean isReg) {
        if (isReg) {
            user = new User();
        }
        //TODO Image
        String name = regName.getText().toString().trim();
        String phone = regPhone.getText().toString().trim();
        String adder = regAdder.getText().toString().trim();
        String pwd = regPwd.getText().toString().trim();
        if (TextUtils.isEmpty(name) || TextUtils.isEmpty(phone) || TextUtils.isEmpty(adder) || TextUtils.isEmpty(pwd)) {
            Toast.makeText(this, "请输入全部信息", Toast.LENGTH_SHORT).show();
            return;
        }
        user.setUsername(name);
        user.setPhone(phone);
        user.setAdder(adder);
        user.setPwd(pwd);
        if (isReg) {
            BuEApplication.getInstance().setUser(user);
        }
        startActivity(new Intent(RegisterActivity.this, TempActivity.class), false);
        finish();
    }
}
