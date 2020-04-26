package com.excitedeven.bue.activity;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.excitedeven.bue.BuEApplication;
import com.excitedeven.bue.R;
import com.excitedeven.bue.adapter.CartAdapter;

public class CartActivity extends BaseActivity {

    private RecyclerView cartRecycler;
    private CartAdapter cartAdapter;

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
    }
}
