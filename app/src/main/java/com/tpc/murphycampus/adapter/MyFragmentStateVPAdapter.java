package com.tpc.murphycampus.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import java.util.List;

public class MyFragmentStateVPAdapter extends FragmentStatePagerAdapter {
    private List<Fragment> fragmentList;


    public MyFragmentStateVPAdapter(@NonNull FragmentManager fm,
                                    List<Fragment> fragmentList) {
        super(fm);
        this.fragmentList=fragmentList;
    }

    //    获取到当前的Fragment
    @NonNull
    @Override
    public Fragment getItem(int position) {
        return fragmentList==null?null:fragmentList.get(position);
    }

    //    获取到当前有多少Fragment
    @Override
    public int getCount() {
        return fragmentList==null?0:fragmentList.size();
    }

}
