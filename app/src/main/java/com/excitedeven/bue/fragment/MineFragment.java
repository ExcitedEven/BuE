package com.excitedeven.bue.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import com.excitedeven.bue.BuEApplication;
import com.excitedeven.bue.R;
import com.excitedeven.bue.activity.HomeActivity;
import com.excitedeven.bue.activity.RegisterActivity;
import com.excitedeven.bue.activity.TempActivity;
import com.excitedeven.bue.bean.User;

/**
 * A simple {@link Fragment} subclass.
 */
public class MineFragment extends Fragment {

    private View layout;
    private TextView uname;
    private TextView uadder;
    private TextView uphone;
    private ImageView ulogo;
    private Button btnLogout;
    private Button btnChange;
    private CardView cardView;

    public MineFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        layout = inflater.inflate(R.layout.fragment_mine, container, false);
        initView();
        return layout;
    }

    private void initView() {
        User user = BuEApplication.getInstance().getUser();
        ulogo = layout.findViewById(R.id.mine_img);
        uname = layout.findViewById(R.id.mine_name);
        uphone = layout.findViewById(R.id.mine_phone);
        uadder = layout.findViewById(R.id.mine_adder);
        btnLogout = layout.findViewById(R.id.btn_logout);
        btnChange = layout.findViewById(R.id.btn_change);
        cardView = layout.findViewById(R.id.cardView);

        if (user == null) {
            cardView.setVisibility(View.INVISIBLE);
            btnChange.setVisibility(View.INVISIBLE);
            btnLogout.setText("Login");
            btnLogout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    ((HomeActivity) getActivity()).startActivity(new Intent(getContext(), TempActivity.class), true);
                }
            });
        } else {
            ulogo.setImageResource(R.drawable.ic_launcher_foreground);
            uname.setText(user.getUsername());
            uadder.setText(user.getAdder());
            uphone.setText(user.getPhone());
            btnLogout.setText("退出");

            btnLogout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    BuEApplication.getInstance().clearUser();
                    //TODO 登出
                    ((HomeActivity) getActivity()).startActivity(new Intent(getContext(), TempActivity.class), false);
                }
            });

            btnChange.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //TODO 更改
                    ((HomeActivity) getActivity()).startActivity(new Intent((getContext()), RegisterActivity.class), false);
                    getActivity().finish();
                }
            });
        }
    }
}
