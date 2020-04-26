package com.excitedeven.bue.activity;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.excitedeven.bue.BuEApplication;
import com.excitedeven.bue.R;

public class FoodActivity extends BaseActivity {

    private ImageView fimg;
    private TextView fname;
    private TextView fprice;
    private Button faddButton;
    private TextView fdescription;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_food;
    }

    @Override
    protected void init() {
        BuEApplication.getInstance().setContext(this);
        fimg = findViewById(R.id.food_img);
        fname = findViewById(R.id.food_name);
        fprice = findViewById(R.id.food_price);
        faddButton = findViewById(R.id.food_add);
        fdescription = findViewById(R.id.food_description);
        faddButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //TODO 添加到购物车
                Toast.makeText(FoodActivity.this, "商品" + fname.getText().toString() + "添加", Toast.LENGTH_SHORT).show();
            }
        });

        initview();
    }

    private void initview() {
        BuEApplication buEApplication = BuEApplication.getInstance();
        fimg.setImageResource(R.drawable.ic_launcher_foreground);
        fname.setText(buEApplication.getFood().getFname());
        fprice.setText(buEApplication.getFood().getFprice() + "元");
        fdescription.setText(buEApplication.getFood().getFdescription());
    }
}
