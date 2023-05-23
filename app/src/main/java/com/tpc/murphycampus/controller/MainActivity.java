package com.tpc.murphycampus.controller;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.content.res.ColorStateList;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.badge.BadgeDrawable;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.tpc.murphycampus.R;
import com.tpc.murphycampus.adapter.MyFragmentStateVPAdapter;
import com.tpc.murphycampus.controller.fragment.MyFragmentHome;
import com.tpc.murphycampus.controller.fragment.MyFragmentUpload;
import com.tpc.murphycampus.controller.fragment.MyFragmentUser;
import com.tpc.murphycampus.utils.StatusBar;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ViewPager viewPager;
    private BottomNavigationView btnNavView;
    private MyFragmentStateVPAdapter myFragmentStateVPAdapter;
    private List<Fragment> fragmentList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        StatusBar statusBar = new StatusBar(MainActivity.this);
        statusBar.setColor(R.color.transparent);
        statusBar.setTextColor(false);

        viewPager=findViewById(R.id.viewpager);
        btnNavView=findViewById(R.id.button_menu);
        btnNavView.setItemIconTintList(null);
        btnNavView.setItemTextColor(ColorStateList.valueOf(getResources().getColor(R.color.black)));

        initData();
        myFragmentStateVPAdapter=new MyFragmentStateVPAdapter(getSupportFragmentManager(),fragmentList);
        viewPager.setAdapter(myFragmentStateVPAdapter);
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                onPagerSelected(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        btnNavView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int itemId = item.getItemId();
                if (itemId == R.id.home) {
                    viewPager.setCurrentItem(0);
                } else if (itemId == R.id.bbs) {
                    viewPager.setCurrentItem(1);
                } else  if (itemId == R.id.mine) {
                    viewPager.setCurrentItem(2);
                }
                return true;
            }
        });
////        创建Badge
//        BadgeDrawable badge=btnNavView.getOrCreateBadge(R.id.home);
//        badge.setNumber(999);
//        badge.setMaxCharacterCount(3);//设置最多显示2个字符
    }

    private void onPagerSelected(int position) {
        switch (position){
            case 0:
                btnNavView.removeBadge(R.id.home);
                btnNavView.setSelectedItemId(R.id.home);
                break;
            case 1:
                btnNavView.removeBadge(R.id.bbs);
                btnNavView.setSelectedItemId(R.id.bbs);
                break;
            case 2:
                btnNavView.removeBadge(R.id.mine);
                btnNavView.setSelectedItemId(R.id.mine);
                break;
            default:
                break;
        }
    }

    private void initData() {
        fragmentList = new ArrayList<>();
        
        MyFragmentHome myFragmentHome = new MyFragmentHome();
        MyFragmentUpload myFragmentUpload = new MyFragmentUpload();
        MyFragmentUser myFragmentUser = new MyFragmentUser();

        fragmentList.add(myFragmentHome);
        fragmentList.add(myFragmentUpload);
        fragmentList.add(myFragmentUser);
    }
}