package com.excitedeven.bue.adapter;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;

import com.excitedeven.bue.BuEApplication;
import com.excitedeven.bue.R;
import com.excitedeven.bue.activity.FoodActivity;
import com.excitedeven.bue.bean.Food;
import com.excitedeven.bue.bean.SelectedFood;

import java.text.MessageFormat;
import java.util.ArrayList;

public class ShopAdapter extends RecyclerView.Adapter {

    private ArrayList<Food> foodList;

    public ShopAdapter(ArrayList<Food> foodList) {
        this.foodList = foodList;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.shop_item, parent, false);
        ViewHolder vh = new ShopViewHolder(view);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, final int position) {
        //TODO 修改商品Image
        ((ShopViewHolder) holder).fimg.setImageResource(R.drawable.ic_launcher_foreground);
        ((ShopViewHolder) holder).fname.setText(MessageFormat.format("{0}家的{1}", BuEApplication.getInstance().getShop().getSname(), foodList.get(position).getFname()));
        ((ShopViewHolder) holder).fdescription.setText(foodList.get(position).getFdescription());
        ((ShopViewHolder) holder).fprice.setText(MessageFormat.format("价格{0}", String.valueOf(foodList.get(position).getFprice())));
        ((ShopViewHolder) holder).addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //TODO 点击添加到购物车
                Toast.makeText(BuEApplication.getInstance().getContext(), "菜品" + position + "添加", Toast.LENGTH_SHORT).show();
                SelectedFood selectedFood = new SelectedFood();
                selectedFood.setFood(foodList.get(position));
                int number = BuEApplication.getInstance().getSelectedFoodList().indexOf(selectedFood);
                if (number == -1) {
                    selectedFood.setNumber(1);
                    BuEApplication.getInstance().getSelectedFoodList().add(selectedFood);
                } else {
                    selectedFood = BuEApplication.getInstance().getSelectedFoodList().get(number);
                    selectedFood.setNumber(selectedFood.getNumber() + 1);
                    BuEApplication.getInstance().getSelectedFoodList().set(number, selectedFood);
                }
            }
        });

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //TODO ShopItem的点击事件
                Toast.makeText(BuEApplication.getInstance().getContext(), "菜品" + position + "onClick", Toast.LENGTH_SHORT).show();
                BuEApplication.getInstance().setFood(foodList.get(position));
                BuEApplication.getInstance().getContext().startActivity(new Intent(BuEApplication.getInstance().getContext(), FoodActivity.class));
            }
        });
    }

    @Override
    public int getItemCount() {
        return foodList.size();
    }

    private class ShopViewHolder extends ViewHolder {
        private ImageView fimg;
        private TextView fname;
        private TextView fdescription;
        private TextView fprice;
        private Button addButton;

        ShopViewHolder(View view) {
            super(view);
            fimg = view.findViewById(R.id.shop_foods_img);
            fname = view.findViewById(R.id.shop_foods_name);
            fdescription = view.findViewById(R.id.shop_foods_description);
            fprice = view.findViewById(R.id.shop_foods_price);
            addButton = view.findViewById(R.id.shop_foods_add);
        }
    }
}
