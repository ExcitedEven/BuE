package com.excitedeven.bue.activity;

import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.excitedeven.bue.BuEApplication;
import com.excitedeven.bue.R;
import com.excitedeven.bue.fragment.ShopInfoFragment;
import com.excitedeven.bue.fragment.ShopMenuFragment;
import com.google.android.material.tabs.TabLayout;

public class ShopActivity extends BaseActivity {

    private ShopPagerAdapter shopPagerAdapter;
    private ViewPager shopPager;
    private TextView textView;
    private TabLayout shopTabLayout;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_shop;
    }

    @Override
    protected void init() {
        BuEApplication.getInstance().setContext(this);
        textView = findViewById(R.id.shop_name);
        textView.setText(BuEApplication.getInstance().getShop().getSname());
        shopPagerAdapter = new ShopPagerAdapter(getSupportFragmentManager());
        shopPager = findViewById(R.id.shop_page);
        shopPager.setAdapter(shopPagerAdapter);

        shopTabLayout = findViewById(R.id.shop_tabs);
        shopTabLayout.setupWithViewPager(shopPager);
    }

    private class ShopPagerAdapter extends FragmentPagerAdapter {
        public ShopPagerAdapter(@NonNull FragmentManager fm) {
            super(fm);
        }

        @NonNull
        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0:
                    return new ShopMenuFragment();
                case 1:
                    return new ShopInfoFragment();
            }
            return null;
        }

        @Override
        public int getCount() {
            return 2;
        }

        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return getResources().getText(R.string.shop_menu);
                case 1:
                    return getResources().getText(R.string.shop_info);
            }
            return null;
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        BuEApplication.getInstance().setContext(this);
    }
}
