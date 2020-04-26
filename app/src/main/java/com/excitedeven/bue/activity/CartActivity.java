package com.excitedeven.bue.activity;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.excitedeven.bue.BuEApplication;
import com.excitedeven.bue.R;
import com.excitedeven.bue.adapter.CartAdapter;

import java.text.MessageFormat;

public class CartActivity extends BaseActivity {

    private RecyclerView cartRecycler;
    private CartAdapter cartAdapter;
    private Button subButton;
    private TextView sum;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_cart;
    }

    @Override
    protected void init() {
        BuEApplication.getInstance().setContext(this);

        cartRecycler = findViewById(R.id.cart_list);
        cartAdapter = new CartAdapter(BuEApplication.getInstance().getSelectedFoodList());
        cartRecycler.setAdapter(cartAdapter);
        cartRecycler.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));

        subButton = findViewById(R.id.cart_sub);
        subButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //TODO 跳转支付, 带登陆判断
                Toast.makeText(CartActivity.this, "结账", Toast.LENGTH_SHORT).show();

            }
        });

        sum = findViewById(R.id.cart_sum);
        refeshSum();
    }

    public void refeshSum() {
        sum.setText(MessageFormat.format("总计{0}元", BuEApplication.getInstance().getSumPrice()));
    }
}
