package com.tpc.murphycampus.adapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import java.util.List;

public class MyHomeFragmentSVpTitleAdapter extends FragmentStatePagerAdapter {
    //传入数据
    private List<Fragment> fragmentList;
    private List<String> titleList;
    //  改造构造方法
    public MyHomeFragmentSVpTitleAdapter(@NonNull FragmentManager fm,
                                         List<Fragment> fragmentList,
                                         List<String> titleList) {
        super(fm);
        this.fragmentList=fragmentList;
        this.titleList=titleList;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return fragmentList == null ? null : fragmentList.get(position);
    }

    @Override
    public int getCount() {
        return fragmentList == null ? 0:fragmentList.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return titleList == null ? "":titleList.get(position);
    }

}