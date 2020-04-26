package com.excitedeven.bue.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.excitedeven.bue.BuEApplication;
import com.excitedeven.bue.R;
import com.excitedeven.bue.activity.CartActivity;
import com.excitedeven.bue.activity.ShopActivity;
import com.excitedeven.bue.adapter.ShopAdapter;
import com.excitedeven.bue.bean.Food;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class ShopMenuFragment extends Fragment {

    private View Layout;
    private ShopAdapter shopAdapter;
    private RecyclerView shopRecyclerView;
    private Button addButton;

    public ShopMenuFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        Layout = inflater.inflate(R.layout.fragment_shop_menu, container, false);

        addButton = Layout.findViewById(R.id.cart);
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //TODO 跳转购物车
                ((ShopActivity) BuEApplication.getInstance().getContext()).startActivity(new Intent(BuEApplication.getInstance().getContext(), CartActivity.class), false);
            }
        });

        initRecyclerView();
        return Layout;
    }

    private void initRecyclerView() {
        shopRecyclerView = Layout.findViewById(R.id.shop_list);
        shopAdapter = new ShopAdapter(getShopList());
        shopRecyclerView.setAdapter(shopAdapter);
        shopRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));

    }

    private ArrayList<Food> getShopList() {
        //TODO 获取真实食物列表
        ArrayList<Food> foodList = new ArrayList<Food>();
        Food food;
        for (int i = 0; i <= 10; i++) {
            food = new Food();
            food.setFname("啊噗鲁派" + i);
            food.setFdescription("能天使最爱" + i);
            food.setFprice(i);
            foodList.add(food);
        }
        BuEApplication.getInstance().getShop().setFoodList(foodList);
        return BuEApplication.getInstance().getShop().getFoodList();
    }
}
