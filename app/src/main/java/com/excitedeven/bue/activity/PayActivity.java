package com.excitedeven.bue.activity;

import android.content.Intent;
import android.os.Handler;

import com.excitedeven.bue.BuEApplication;
import com.excitedeven.bue.R;
import com.excitedeven.bue.bean.Order;

import java.util.ArrayList;
import java.util.Calendar;

public class PayActivity extends BaseActivity {

    @Override
    protected int getLayoutId() {
        return R.layout.activity_pay;
    }

    @Override
    protected void init() {
        // TODO 添加order
        BuEApplication buEApplication = BuEApplication.getInstance();
        Order order = new Order();
        order.setShopName(buEApplication.getShop().getSname());
        order.setSelectedFoodList(buEApplication.getSelectedFoodList());
        order.setAdder(buEApplication.getUser().getAdder());
        order.setSum(buEApplication.getSumPrice());
        order.setTime(Calendar.getInstance().getTimeInMillis());
        if (buEApplication.getUser().getOrderList() != null) {
            buEApplication.getUser().getOrderList().add(order);
        } else {
            ArrayList<Order> orderList = new ArrayList<Order>();
            orderList.add(order);
            buEApplication.getUser().setOrderList(orderList);
        }
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                //TODO 跳转订单页面
                Intent intent = new Intent(PayActivity.this, HomeActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
//                intent.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
                startActivity(intent, false);
            }
        }, 1000);
    }

    @Override
    protected void onResume() {
        super.onResume();
        BuEApplication.getInstance().setContext(this);
    }
}
