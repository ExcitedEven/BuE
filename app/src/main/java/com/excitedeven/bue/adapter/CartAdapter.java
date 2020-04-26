package com.excitedeven.bue.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;

import com.excitedeven.bue.BuEApplication;
import com.excitedeven.bue.R;
import com.excitedeven.bue.activity.CartActivity;
import com.excitedeven.bue.bean.Food;
import com.excitedeven.bue.bean.SelectedFood;

import java.util.ArrayList;

public class CartAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private ArrayList<SelectedFood> selectedFoodList;

    public CartAdapter(ArrayList<SelectedFood> selectedFoodList) {
        this.selectedFoodList = selectedFoodList;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cart_item, parent, false);
        ViewHolder vh = new CartViewHolder(view);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, final int position) {
        Food food = selectedFoodList.get(position).getFood();
        int number = selectedFoodList.get(position).getNumber();
        ((CartViewHolder) holder).fname.setText(food.getFname());
        ((CartViewHolder) holder).fprice.setText(String.format("%s元", String.valueOf(selectedFoodList.get(position).getSum())));
        ((CartViewHolder) holder).number.setText(String.valueOf(number));
        ((CartViewHolder) holder).rButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //TODO 减少
                Toast.makeText(BuEApplication.getInstance().getContext(), "减一", Toast.LENGTH_SHORT).show();
                SelectedFood selectedFood = selectedFoodList.get(position);
                int number = BuEApplication.getInstance().getSelectedFoodList().indexOf(selectedFood);
                selectedFood.setNumber(selectedFood.getNumber() - 1);
                if (selectedFood.getNumber() <= 0) {
                    BuEApplication.getInstance().getSelectedFoodList().remove(number);
                    notifyItemRemoved(position);
                    notifyItemRangeRemoved(position, getItemCount());
                } else {
                    BuEApplication.getInstance().getSelectedFoodList().set(number, selectedFood);
                    notifyItemChanged(position);
                }
                ((CartActivity) BuEApplication.getInstance().getContext()).refeshSum();
            }
        });
        ((CartViewHolder) holder).aButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //TODO 增加
                Toast.makeText(BuEApplication.getInstance().getContext(), "加一", Toast.LENGTH_SHORT).show();
                SelectedFood selectedFood = selectedFoodList.get(position);
                int number = BuEApplication.getInstance().getSelectedFoodList().indexOf(selectedFood);
                selectedFood.setNumber(selectedFood.getNumber() + 1);
                BuEApplication.getInstance().getSelectedFoodList().set(number, selectedFood);
                notifyItemChanged(position);
                ((CartActivity) BuEApplication.getInstance().getContext()).refeshSum();
            }
        });
    }

    @Override
    public int getItemCount() {
        return selectedFoodList.size();
    }

    private class CartViewHolder extends ViewHolder {
        private TextView fname;
        private TextView fprice;
        private TextView number;
        private Button rButton;
        private Button aButton;

        public CartViewHolder(View view) {
            super(view);
            fname = view.findViewById(R.id.cart_food_name);
            fprice = view.findViewById(R.id.cart_food_price);
            number = view.findViewById(R.id.cart_food_number);
            rButton = view.findViewById(R.id.cart_food_reduce);
            aButton = view.findViewById(R.id.cart_food_add);
        }
    }
}
