package com.excitedeven.bue.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.excitedeven.bue.BuEApplication;
import com.excitedeven.bue.R;
import com.excitedeven.bue.adapter.OrderAdapter;
import com.excitedeven.bue.bean.Order;
import com.excitedeven.bue.bean.User;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class AllOrderFragment extends Fragment {

    private View Layout;
    private OrderAdapter orderAdapter;
    private RecyclerView orderRecyclerView;

    public AllOrderFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        Layout = inflater.inflate(R.layout.fragment_all_order, container, false);

        initRecyclerView();
        return Layout;
    }

    private void initRecyclerView() {
        User user = BuEApplication.getInstance().getUser();
        orderRecyclerView = Layout.findViewById(R.id.order_list);
        //第一次进来User为空
        if (user == null) {
            user = new User();
            orderAdapter = new OrderAdapter(user.getOrderList());
        } else {
            ArrayList<Order> orderArrayList = user.getOrderList();
            orderAdapter = new OrderAdapter(orderArrayList);
        }
        orderRecyclerView.setAdapter(orderAdapter);
        orderRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
    }
}
