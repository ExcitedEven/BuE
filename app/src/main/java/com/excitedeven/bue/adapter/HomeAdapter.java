package com.excitedeven.bue.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;

import com.excitedeven.bue.R;
import com.excitedeven.bue.bean.Store;

import java.util.ArrayList;

public class HomeAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private ArrayList<Store> storeList;
    private Store store;

    public HomeAdapter(ArrayList<Store> storeList) {
        this.storeList = storeList;
    }

    public HomeAdapter(Store store) {
        this.store = store;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false);
        ViewHolder vh = new HomeViewHolder(view);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        //TODO 修改Image
        ((HomeViewHolder) holder).slogo.setImageResource(R.drawable.ic_launcher_background);
        ((HomeViewHolder) holder).sname.setText(storeList.get(position).getSname());
        ((HomeViewHolder) holder).sdescription.setText(storeList.get(position).getSdescription());
    }

    @Override
    public int getItemCount() {
        return storeList.size();
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
