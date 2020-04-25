package com.excitedeven.bue.activity;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
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

    SectionPagerAdapter pagerAdapter;
    ViewPager pager;
    TabLayout tabLayout;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_home;
    }

    @Override
    protected void init() {
        BuEApplication.getInstance().setContext(this);
        pagerAdapter = new SectionPagerAdapter(getSupportFragmentManager());
        pager = findViewById(R.id.home_page);
        pager.setAdapter(pagerAdapter);

        tabLayout = findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(pager);
    }

    /**
     * 管理ViewPager
     */
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

        /**
         * 设置toolbar的内容
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
