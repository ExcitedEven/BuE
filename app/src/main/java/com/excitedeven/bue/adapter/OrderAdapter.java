package com.excitedeven.bue.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;

import com.excitedeven.bue.BuEApplication;
import com.excitedeven.bue.R;
import com.excitedeven.bue.bean.Order;
import com.excitedeven.bue.bean.User;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class OrderAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private ArrayList<Order> orderList;

    public OrderAdapter(ArrayList<Order> orderList) {
        if (orderList == null) {
            orderList = new ArrayList<Order>();
        }
        this.orderList = orderList;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.order_item, parent, false);
        ViewHolder vh = new OrderViewHolder(view);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        User user = BuEApplication.getInstance().getUser();
        //TODO 修改商家Image
        ((OrderViewHolder) holder).oimg.setImageResource(R.drawable.ic_launcher_foreground);
        ((OrderViewHolder) holder).oname.setText(user.getOrderList().get(position).getShopName());
        ((OrderViewHolder) holder).otime.setText(stampToDate(user.getOrderList().get(position).getTime()));
        ((OrderViewHolder) holder).ofood.setText(user.getOrderList().get(position).getSelectedFoodList().get(0).getFood().getFname());
        ((OrderViewHolder) holder).oprice.setText(String.format("总计%s元", String.valueOf(user.getOrderList().get(position).getSum())));
    }

    private String stampToDate(long time) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("YYYY-MM-dd HH:mm");
        Date date = new Date(time);
        return simpleDateFormat.format(date);
    }

    @Override
    public int getItemCount() {
        return orderList.size();
    }

    private class OrderViewHolder extends ViewHolder {
        private ImageView oimg;
        private TextView oname;
        private TextView otime;
        private TextView ofood;
        private TextView oprice;

        public OrderViewHolder(View view) {
            super(view);

            oimg = view.findViewById(R.id.order_logo);
            oname = view.findViewById(R.id.order_name);
            otime = view.findViewById(R.id.order_time);
            ofood = view.findViewById(R.id.order_food);
            oprice = view.findViewById(R.id.order_price);
        }
    }
}
