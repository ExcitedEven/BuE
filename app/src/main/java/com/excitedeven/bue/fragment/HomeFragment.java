package com.excitedeven.bue.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.excitedeven.bue.R;
import com.excitedeven.bue.adapter.HomeAdapter;
import com.excitedeven.bue.bean.Store;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {

    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View Layout = inflater.inflate(R.layout.fragment_home, container, false);
        RecyclerView homeRecyclerView = Layout.findViewById(R.id.home_list);
        Context context;
        HomeAdapter homeAdapter = new HomeAdapter(getStoreList());
        homeRecyclerView.setAdapter(homeAdapter);
        homeRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
//        homeRecyclerView.setHasFixedSize(true);
        return Layout;
    }

    /**
     * 获取商家类
     * @return 返回商家类表
     */
    //TODO 获取真实数据
    private ArrayList<Store> getStoreList() {
        ArrayList<Store> storeArrayList = new ArrayList<Store>();
        Store store = new Store();
        store.setSname("even");
        store.setSdescription("ForTest");
        for (int i = 0; i <= 100; i++) {
            storeArrayList.add(store);
        }
        return storeArrayList;
    }
}
