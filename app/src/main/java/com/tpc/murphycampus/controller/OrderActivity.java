package com.tpc.murphycampus.controller;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;
import com.tpc.murphycampus.R;
import com.tpc.murphycampus.adapter.MyHomeFragmentSVpTitleAdapter;
import com.tpc.murphycampus.controller.fragment.MyFragmentOrderAll;
import com.tpc.murphycampus.controller.fragment.MyFragmentOrderAppraise;
import com.tpc.murphycampus.controller.fragment.MyFragmentOrderFinished;
import com.tpc.murphycampus.controller.fragment.MyFragmentOrderPending;
import com.tpc.murphycampus.controller.fragment.MyFragmentOrderUnfinished;
import com.tpc.murphycampus.dao.ErrandDao;
import com.tpc.murphycampus.dao.impl.ErrandDaoImpl;
import com.tpc.murphycampus.dao.impl.UserDaoImpl;
import com.tpc.murphycampus.pojo.Errand;
import com.tpc.murphycampus.pojo.User;
import com.tpc.murphycampus.utils.StatusBar;

import java.util.ArrayList;
import java.util.List;

public class OrderActivity extends AppCompatActivity {

    private TabLayout tabLayout;
    private ViewPager viewPager;
    private List<Fragment> fragmentList;
    private List<String> titleList;
    private MyHomeFragmentSVpTitleAdapter myHomeFragmentSVpTitleAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);

        StatusBar statusBar = new StatusBar(OrderActivity.this);
        statusBar.setColor(R.color.transparent);
        statusBar.setTextColor(false);

        initData();

        viewPager = findViewById(R.id.viewpagerhome);
        tabLayout = findViewById(R.id.tablayout);

        myHomeFragmentSVpTitleAdapter=new MyHomeFragmentSVpTitleAdapter(getSupportFragmentManager(),fragmentList,titleList);

        viewPager.setAdapter(myHomeFragmentSVpTitleAdapter);
        tabLayout.setupWithViewPager(viewPager);

    }

    private void initData() {
        fragmentList=new ArrayList<>();

        MyFragmentOrderPending myFragmentOrderPending = new MyFragmentOrderPending();
        MyFragmentOrderUnfinished myFragmentOrderUnfinished = new MyFragmentOrderUnfinished();
        MyFragmentOrderFinished myFragmentOrderFinished = new MyFragmentOrderFinished();
        MyFragmentOrderAppraise myFragmentOrderAppraise = new MyFragmentOrderAppraise();
        MyFragmentOrderAll myFragmentOrderAll = new MyFragmentOrderAll();

        fragmentList.add(myFragmentOrderPending);
        fragmentList.add(myFragmentOrderUnfinished);
        fragmentList.add(myFragmentOrderFinished);
        fragmentList.add(myFragmentOrderAppraise);
        fragmentList.add(myFragmentOrderAll);

        titleList=new ArrayList<>();

        titleList.add("待接单");
        titleList.add("待完成");
        titleList.add("已完成");
        titleList.add("待评价");
        titleList.add("全部");
    }
}