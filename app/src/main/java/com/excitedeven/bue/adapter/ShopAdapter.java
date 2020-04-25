package com.excitedeven.bue.adapter;

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
import com.excitedeven.bue.bean.Dishes;

import java.text.MessageFormat;
import java.util.ArrayList;

public class ShopAdapter extends RecyclerView.Adapter {

    private ArrayList<Dishes> dishesList;

    public ShopAdapter(ArrayList<Dishes> dishesList) {
        this.dishesList = dishesList;
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
        ((ShopViewHolder) holder).dimg.setImageResource(R.drawable.ic_launcher_foreground);
        ((ShopViewHolder) holder).dname.setText(dishesList.get(position).getDname());
        ((ShopViewHolder) holder).ddescription.setText(dishesList.get(position).getDdescription());
        ((ShopViewHolder) holder).dprice.setText(MessageFormat.format("价格{0}", String.valueOf(dishesList.get(position).getDprice())));
        ((ShopViewHolder) holder).addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //TODO 点击添加到购物车
                Toast.makeText(BuEApplication.getInstance().getContext(), "菜品" + position + "添加", Toast.LENGTH_SHORT).show();
            }
        });

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //TODO ShopItem的点击事件
                Toast.makeText(BuEApplication.getInstance().getContext(), "菜品" + position + "onClick", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return dishesList.size();
    }

    private class ShopViewHolder extends ViewHolder {
        private ImageView dimg;
        private TextView dname;
        private TextView ddescription;
        private TextView dprice;
        private Button addButton;

        ShopViewHolder(View view) {
            super(view);
            dimg = view.findViewById(R.id.shop_dishes_img);
            dname = view.findViewById(R.id.shop_dishes_name);
            ddescription = view.findViewById(R.id.shop_dishes_description);
            dprice = view.findViewById(R.id.shop_dishes_price);
            addButton = view.findViewById(R.id.shop_dishes_add);
        }
    }
}
