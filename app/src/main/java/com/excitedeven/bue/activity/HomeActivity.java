package com.excitedeven.bue.activity;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.excitedeven.bue.BuEApplication;
import com.excitedeven.bue.R;
import com.excitedeven.bue.fragment.AllOrderFragment;
import com.excitedeven.bue.fragment.HomeFragment;
import com.excitedeven.bue.fragment.MineFragment;
import com.google.android.material.tabs.TabLayout;

public class HomeActivity extends BaseActivity {

    HomePagerAdapter homePagerAdapter;
    ViewPager homePager;
    TabLayout homeTabLayout;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_home;
    }

    @Override
    protected void init() {
        BuEApplication.getInstance().setContext(this);
        homePagerAdapter = new HomePagerAdapter(getSupportFragmentManager());
        homePager = findViewById(R.id.home_page);
        homePager.setAdapter(homePagerAdapter);

        homeTabLayout = findViewById(R.id.home_tabs);
        homeTabLayout.setupWithViewPager(homePager);
    }

    @Override
    protected void onResume() {
        super.onResume();
        BuEApplication.getInstance().setContext(this);
    }

    /**
     * 管理ViewPager
     */
    private class HomePagerAdapter extends FragmentPagerAdapter {
        public HomePagerAdapter(@NonNull FragmentManager fm) {
            super(fm);
        }

        @NonNull
        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0:
                    return new HomeFragment();
                case 1:
                    return new AllOrderFragment();
                case 2:
                    return new MineFragment();
            }
            return null;
        }

        @Override
        public int getCount() {
            return 3;
        }

        /**
         * 设置toolbar的内容
         *
         * @param position
         * @return
         */
        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return getResources().getText(R.string.home);
                case 1:
                    return getResources().getText(R.string.order);
                case 2:
                    return getResources().getText(R.string.mine);
            }
            return null;
        }
    }
}
