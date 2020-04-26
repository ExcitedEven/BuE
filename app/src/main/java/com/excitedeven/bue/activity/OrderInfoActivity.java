package com.excitedeven.bue.activity;

import android.util.Log;
import android.view.View;
import android.widget.TextView;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.excitedeven.bue.BuEApplication;
import com.excitedeven.bue.R;
import com.excitedeven.bue.adapter.OrderInfoAdapter;

public class OrderInfoActivity extends BaseActivity {

    private TextView sname;
    private TextView uname;
    private TextView uadder;
    private RecyclerView orderRecycler;
    private OrderInfoAdapter orderInfoAdapter;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_order_info;
    }

    @Override
    protected void init() {
        orderRecycler = findViewById(R.id.foods_in_order);
        orderInfoAdapter = new OrderInfoAdapter(BuEApplication.getInstance().getOrder());

        orderRecycler.setAdapter(orderInfoAdapter);
        orderRecycler.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));

        uname = findViewById(R.id.order_info_username);
        uadder = findViewById(R.id.order_info_useradder);
        uname.setText(BuEApplication.getInstance().getUser().getUsername());
        uadder.setText(BuEApplication.getInstance().getUser().getAdder());

        sname = findViewById(R.id.order_info_shopname);
        sname.setText(BuEApplication.getInstance().getOrder().getShopName());
        sname.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //TODO 跳转Shop页面
                Log.v("OrderActivity", "跳转Shop");
            }
        });
    }
}
