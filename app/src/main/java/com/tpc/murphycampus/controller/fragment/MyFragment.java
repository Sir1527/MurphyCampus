package com.tpc.murphycampus.controller.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.tpc.murphycampus.R;

public class MyFragment extends Fragment {
//
//    // TODO: 系统预留的接收外界数据的变量
//    private static final String ARG_PARAM1 = "param1";
//    private String mParam1;
//
//    //    声明文本控件变量
//    private TextView textView;
//
//    //    外部通过newInstance实例化fragment,并带入外界传入的参数
//    //    参数存在Bundle对象中
//    public static MyFragment newInstance(String param1) {
//
//        MyFragment fragment = new MyFragment();
//        Bundle args = new Bundle();
//        args.putString(ARG_PARAM1, param1);
//        fragment.setArguments(args);
//        return fragment;
//
//    }
//
//
//    //      取出存在Bundle中的数据
//    @Override
//    public void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        if (getArguments() != null) {
//            mParam1 = getArguments().getString(ARG_PARAM1);
//        }
//    }
//
//    @Override
//    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
//        return inflater.inflate(R.layout.fragment_my, container, false);
//    }
//
//    @Override
//    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
//
////      通过view找到布局中的文本控件
//        textView=view.findViewById(R.id.textView);
////      设置为外界传入的参数
//        textView.setText(mParam1);
//        super.onViewCreated(view, savedInstanceState);
//    }
}
