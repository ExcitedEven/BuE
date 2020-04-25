package com.excitedeven.bue.adapter;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;

import com.excitedeven.bue.BuEApplication;
import com.excitedeven.bue.R;
import com.excitedeven.bue.activity.ShopActivity;
import com.excitedeven.bue.bean.Shop;

import java.util.ArrayList;

public class HomeAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private ArrayList<Shop> shopList;

    public HomeAdapter(ArrayList<Shop> shopList) {
        this.shopList = shopList;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.home_item, parent, false);
        ViewHolder vh = new HomeViewHolder(view);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, final int position) {
        //TODO 修改Image
        ((HomeViewHolder) holder).slogo.setImageResource(R.drawable.ic_launcher_foreground);
        ((HomeViewHolder) holder).sname.setText(shopList.get(position).getSname());
        ((HomeViewHolder) holder).sdescription.setText(shopList.get(position).getSdescription());

        /**
         * HomeItem的点击事件
         */
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //TODO HomeItem的点击事件
                Toast.makeText(BuEApplication.getInstance().getContext(), position + "Onclick", Toast.LENGTH_SHORT).show();
                BuEApplication.getInstance().setShop(shopList.get(position));
                Intent intent = new Intent(BuEApplication.getInstance().getContext(), ShopActivity.class);
                BuEApplication.getInstance().getContext().startActivity(intent);
                /**
                 * 示例
                 * BuEApplication.getInstance().getContext().startActivity(new Intent(BuEApplication.getInstance().getContext(), LoginActivity.class));
                 */
            }
        });
    }

    @Override
    public int getItemCount() {
        return shopList.size();
    }

    private class HomeViewHolder extends ViewHolder {

        private ImageView slogo;
        private TextView sname;
        private TextView sdescription;

        public HomeViewHolder(View view) {
            super(view);
            slogo = view.findViewById(R.id.home_logo);
            sname = view.findViewById(R.id.home_sname);
            sdescription = view.findViewById(R.id.home_description);
        }
    }
}
