package com.excitedeven.bue.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.excitedeven.bue.BuEApplication;
import com.excitedeven.bue.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class ShopInfoFragment extends Fragment {

    private View Layout;
    private ImageView img;
    private TextView sname;
    private TextView sdescription;

    public ShopInfoFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        Layout = inflater.inflate(R.layout.fragment_shop_info, container, false);
        img = Layout.findViewById(R.id.shop_info_img);
        sname = Layout.findViewById(R.id.shop_info_name);
        sdescription = Layout.findViewById(R.id.shop_info_description);
        showInfo();
        return Layout;
    }

    private void showInfo() {
        img.setImageResource(R.drawable.ic_launcher_foreground);
        sname.setText(BuEApplication.getInstance().getShop().getSname());
        sdescription.setText(BuEApplication.getInstance().getShop().getSdescription());
    }
}
