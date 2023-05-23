package com.tpc.murphycampus.controller.fragment;

import static android.content.Context.MODE_PRIVATE;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.tpc.murphycampus.controller.MyOrderActivity;
import com.tpc.murphycampus.controller.OrderActivity;
import com.tpc.murphycampus.R;
import com.tpc.murphycampus.controller.updateUserActivity;
import com.tpc.murphycampus.dao.UserDao;
import com.tpc.murphycampus.dao.impl.UserDaoImpl;
import com.tpc.murphycampus.pojo.User;

public class MyFragmentUser extends Fragment {

    private View allOrders;
    private TextView userName,phone;
    private UserDao userDao;
    private int uid;
    private View pending;
    private View unfinished;
    private View finished;
    private View appraise;
    private View myOrder;
    private View userModify_1;
    private View userModify_2;
    private SharedPreferences sharedPreferences;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main_user, container, false);

        userName = view.findViewById(R.id.user_nickname);
        phone = view.findViewById(R.id.phone);

        sharedPreferences = getActivity().getSharedPreferences("userInfo",MODE_PRIVATE);
        uid = sharedPreferences.getInt("userUid",0);
        System.out.println(uid);

        userDao = new UserDaoImpl(getContext());
        User user = userDao.findByUid(uid);

        userName.setText(user.getName());
        phone.setText(user.getPhone());

        allOrders = view.findViewById(R.id.text_order_title2);
        allOrders.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), OrderActivity.class);
                startActivity(intent);
            }
        });

        pending = view.findViewById(R.id.imageView1);
        unfinished = view.findViewById(R.id.view3);
        finished = view.findViewById(R.id.imageView6);
        appraise = view.findViewById(R.id.imageView7);
        myOrder = view.findViewById(R.id.textView12);
        userModify_1 = view.findViewById(R.id.imageView4);
        userModify_2 = view.findViewById(R.id.textView34);

        pending.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), OrderActivity.class);
                startActivity(intent);
            }
        });

        unfinished.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), OrderActivity.class);
                startActivity(intent);
            }
        });

        finished.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), OrderActivity.class);
                startActivity(intent);
            }
        });

        appraise.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), OrderActivity.class);
                startActivity(intent);
            }
        });

        myOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), MyOrderActivity.class);
                startActivity(intent);
            }
        });

        userModify_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), updateUserActivity.class);
                startActivity(intent);
            }
        });

        userModify_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), updateUserActivity.class);
                startActivity(intent);
            }
        });

        return view;
    }

}
