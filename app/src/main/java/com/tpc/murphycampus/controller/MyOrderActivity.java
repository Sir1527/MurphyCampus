package com.tpc.murphycampus.controller;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.tpc.murphycampus.R;
import com.tpc.murphycampus.adapter.HomeRecycleAdapter;
import com.tpc.murphycampus.dao.ErrandDao;
import com.tpc.murphycampus.dao.impl.ErrandDaoImpl;
import com.tpc.murphycampus.pojo.Errand;
import com.tpc.murphycampus.utils.RecyclerViewSpacesItemDecoration;
import com.tpc.murphycampus.utils.StatusBar;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MyOrderActivity extends AppCompatActivity {

    private ErrandDao errandDao;
    public RecyclerView homeRecyclerView;
    private HomeRecycleAdapter homeRecycleAdapter;
    private ArrayList<Errand> orderList = new ArrayList<Errand>();
    private SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_order);

        StatusBar statusBar = new StatusBar(MyOrderActivity.this);
        statusBar.setColor(R.color.transparent);
        statusBar.setTextColor(false);

        initData();
        initRecyclerView();
        RecyclerView viewById = findViewById(R.id.recyclerViewMyOrder);

        HashMap<String, Integer> stringIntegerHashMap = new HashMap<>();
        stringIntegerHashMap.put(RecyclerViewSpacesItemDecoration.TOP_DECORATION,20);
        stringIntegerHashMap.put(RecyclerViewSpacesItemDecoration.BOTTOM_DECORATION,20);
        viewById.addItemDecoration(new RecyclerViewSpacesItemDecoration(stringIntegerHashMap));
    }

    private void initData() {
        errandDao = new ErrandDaoImpl(getApplicationContext());
        sharedPreferences = getSharedPreferences("userInfo",MODE_PRIVATE);
        int uid = sharedPreferences.getInt("userUid",0);
        List<Errand> all = errandDao.getByAcceptIdAndStatus(uid,"待完成");
        orderList = (ArrayList<Errand>) all;
    }

    private void initRecyclerView() {
        homeRecyclerView = (RecyclerView)findViewById(R.id.recyclerViewMyOrder);
        homeRecycleAdapter = new HomeRecycleAdapter(MyOrderActivity.this,orderList);
        homeRecyclerView.setAdapter(homeRecycleAdapter);
        homeRecyclerView.setLayoutManager(new LinearLayoutManager(MyOrderActivity.this,LinearLayoutManager.VERTICAL,false));
        homeRecycleAdapter.setOnItemClickListener(new HomeRecycleAdapter.OnItemClickListener() {
            @Override
            public void OnItemClick(View view, Errand data) {
                errandDao =  new ErrandDaoImpl(getApplicationContext());
//                sharedPreferences = MyOrderActivity.this.getSharedPreferences("userInfo",MODE_PRIVATE);
//                int uid = sharedPreferences.getInt("userUid",0);
//                data.setAcceptId(uid);
                data.setStatus("已完成");
                errandDao.updateErrandByAcceptId(data);
                Toast.makeText(getApplicationContext(),"完成差事！",Toast.LENGTH_LONG).show();
            }
        });
    }
}