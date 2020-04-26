package com.excitedeven.bue.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;

import com.excitedeven.bue.R;
import com.excitedeven.bue.bean.Order;
import com.excitedeven.bue.bean.SelectedFood;

import java.util.ArrayList;

public class OrderInfoAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Order order;
    private ArrayList<SelectedFood> selectedFoods;

    public OrderInfoAdapter(Order order) {
        this.order = order;
        selectedFoods = order.getSelectedFoodList();
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.order_info_item, parent, false);
        ViewHolder vh = new OrderInfoViewHolder(view);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ((OrderInfoViewHolder) holder).fname.setText(selectedFoods.get(position).getFood().getFname());
        ((OrderInfoViewHolder) holder).fprice.setText(String.valueOf(selectedFoods.get(position).getSum()));
    }

    @Override
    public int getItemCount() {
        return order.getSelectedFoodList().size();
    }

    private class OrderInfoViewHolder extends ViewHolder {
        private TextView fname;
        private TextView fprice;

        public OrderInfoViewHolder(View view) {
            super(view);
            fname = view.findViewById(R.id.food_in_order_name);
            fprice = view.findViewById(R.id.food_in_order_price);
        }
    }
}
