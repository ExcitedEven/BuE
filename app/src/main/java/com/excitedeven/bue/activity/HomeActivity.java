package com.excitedeven.bue.activity;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.excitedeven.bue.R;
import com.excitedeven.bue.fragment.AllOrderFragment;
import com.excitedeven.bue.fragment.HomeFragment;
import com.excitedeven.bue.fragment.MineFragment;

public class HomeActivity extends BaseActivity {

    SectionPagerAdapter pagerAdapter;
    ViewPager pager;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_home;
    }

    @Override
    protected void init() {
        pagerAdapter = new SectionPagerAdapter(getSupportFragmentManager());
        pager = findViewById(R.id.home_page);
        pager.setAdapter(pagerAdapter);
    }

    private class SectionPagerAdapter extends FragmentPagerAdapter {
        public SectionPagerAdapter(@NonNull FragmentManager fm) {
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
    }
}
