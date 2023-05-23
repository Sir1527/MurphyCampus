package com.tpc.murphycampus.controller.fragment;

import static android.content.Context.MODE_PRIVATE;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.tpc.murphycampus.R;
import com.tpc.murphycampus.adapter.HomeRecycleAdapter;
import com.tpc.murphycampus.dao.ErrandDao;
import com.tpc.murphycampus.dao.impl.ErrandDaoImpl;
import com.tpc.murphycampus.pojo.Errand;
import com.tpc.murphycampus.utils.RecyclerViewSpacesItemDecoration;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MyFragmentOrderAll extends Fragment {
    private View view;
    public RecyclerView homeRecyclerView;
    private ArrayList<Errand> orderList = new ArrayList<Errand>();
    private HomeRecycleAdapter homeRecycleAdapter;
    private ErrandDao errandDao;

    private SharedPreferences sharedPreferences;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_order_all, container, false);
        initData();
        initRecyclerView();
        RecyclerView viewById = view.findViewById(R.id.recyclerViewOrderAll);

        HashMap<String, Integer> stringIntegerHashMap = new HashMap<>();
        stringIntegerHashMap.put(RecyclerViewSpacesItemDecoration.TOP_DECORATION,20);
        stringIntegerHashMap.put(RecyclerViewSpacesItemDecoration.BOTTOM_DECORATION,20);
        viewById.addItemDecoration(new RecyclerViewSpacesItemDecoration(stringIntegerHashMap));
        return view;
    }

    private void initData() {
        errandDao = new ErrandDaoImpl(getContext());
        sharedPreferences = getActivity().getSharedPreferences("userInfo",MODE_PRIVATE);
        int uid = sharedPreferences.getInt("userUid",0);
        List<Errand> all = errandDao.getStatusByByPublisherId(uid);
        orderList = (ArrayList<Errand>) all;
    }

    private void initRecyclerView() {
        homeRecyclerView = (RecyclerView)view.findViewById(R.id.recyclerViewOrderAll);
        homeRecycleAdapter = new HomeRecycleAdapter(getActivity(),orderList);
        homeRecyclerView.setAdapter(homeRecycleAdapter);
        homeRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity(),LinearLayoutManager.VERTICAL,false));
        homeRecycleAdapter.setOnItemClickListener(new HomeRecycleAdapter.OnItemClickListener() {
            @Override
            public void OnItemClick(View view, Errand data) {

            }
        });
    }

}
