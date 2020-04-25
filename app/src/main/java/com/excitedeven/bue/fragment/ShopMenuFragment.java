package com.excitedeven.bue.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.excitedeven.bue.R;
import com.excitedeven.bue.adapter.ShopAdapter;
import com.excitedeven.bue.bean.Dishes;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class ShopMenuFragment extends Fragment {

    private View Layout;
    private ShopAdapter shopAdapter;
    private RecyclerView shopRecyclerView;

    public ShopMenuFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        Layout = inflater.inflate(R.layout.fragment_shop_menu, container, false);
        initRecyclerView();
        return Layout;
    }

    private void initRecyclerView() {
        shopRecyclerView = Layout.findViewById(R.id.shop_list);
        shopAdapter = new ShopAdapter(getShopList());
        shopRecyclerView.setAdapter(shopAdapter);
        shopRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));

    }

    private ArrayList<Dishes> getShopList() {
        ArrayList<Dishes> dishesList = new ArrayList<Dishes>();
        Dishes dishes;
        for (int i = 0; i <= 10; i++) {
            dishes = new Dishes();
            dishes.setDname("啊噗鲁派" + i);
            dishes.setDdescription("能天使最爱" + i);
            dishes.setDprice(i);
            dishesList.add(dishes);
        }
        return dishesList;
    }
}
