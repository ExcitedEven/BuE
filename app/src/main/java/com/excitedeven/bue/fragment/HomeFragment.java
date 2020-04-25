package com.excitedeven.bue.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.excitedeven.bue.R;
import com.excitedeven.bue.adapter.HomeAdapter;
import com.excitedeven.bue.bean.Shop;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {

    private HomeAdapter homeAdapter;
    private View Layout;
    private RecyclerView homeRecyclerView;

    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        Layout = inflater.inflate(R.layout.fragment_home, container, false);
        initRecyclerView();
        return Layout;
    }

    /**
     * 获取商家类
     *
     * @return 返回商家类表
     */
    //TODO 获取真实数据
    private ArrayList<Shop> getStoreList() {
        ArrayList<Shop> shopArrayList = new ArrayList<Shop>();
        Shop shop;
        for (int i = 0; i <= 100; i++) {
            shop = new Shop();
            shop.setSname("Even" + i);
            shop.setSdescription("ForTest" + i);
            shopArrayList.add(shop);
        }
        return shopArrayList;
    }

    public void initRecyclerView() {
        homeRecyclerView = Layout.findViewById(R.id.home_list);
        homeAdapter = new HomeAdapter(getStoreList());
        homeRecyclerView.setAdapter(homeAdapter);
        homeRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
    }
}
