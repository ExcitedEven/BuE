package com.excitedeven.bue;

import android.app.Application;
import android.content.Context;
import android.content.Intent;

import com.excitedeven.bue.bean.Food;
import com.excitedeven.bue.bean.SelectedFood;
import com.excitedeven.bue.bean.Shop;
import com.excitedeven.bue.bean.User;

import java.util.ArrayList;
import java.util.Iterator;

public class BuEApplication extends Application {
    private User user;
    private Shop shop;
    private Food food;
    private ArrayList<SelectedFood> selectedFoodList;
    private static BuEApplication mInstance;
    private Intent intent;
    private Context context;

    public static BuEApplication getInstance() {
        return mInstance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        mInstance = this;
    }

    public void initUser() {
        //TODO 从本地获取User
    }

    public User getUser() {
        return user;
    }

    public void clearUser() {
        this.user = null;
        //TODO 将本地的User也清除
    }

    public Intent getIntent() {
        return intent;
    }

    public void setIntent(Intent intent) {
        this.intent = intent;
    }

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    public Shop getShop() {
        return shop;
    }

    public void setShop(Shop shop) {
        this.shop = shop;
    }

    public Food getFood() {
        return food;
    }

    public void setFood(Food food) {
        this.food = food;
    }

    public ArrayList<SelectedFood> getSelectedFoodList() {
        return selectedFoodList;
    }

    public void setSelectedFoodList(ArrayList<SelectedFood> selectedFoodList) {
        this.selectedFoodList = selectedFoodList;
    }

    /**
     * 获取总价
     *
     * @return
     */
    public Long getSumPrice() {
        if (!hasSelectedFood()) {
            return 0l;
        }
        long sum = selectedFoodList.get(0).getSum();
        Iterator<SelectedFood> it = selectedFoodList.iterator();

        while (it.hasNext()) {
            sum += it.next().getSum();
        }

        return sum;
    }

    public boolean hasSelectedFood() {
        if (selectedFoodList.size() == 0) {
            return false;
        }
        return true;
    }
}
