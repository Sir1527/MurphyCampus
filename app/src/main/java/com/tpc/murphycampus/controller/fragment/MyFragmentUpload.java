package com.tpc.murphycampus.controller.fragment;

import static android.content.Context.MODE_PRIVATE;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.tpc.murphycampus.R;
import com.tpc.murphycampus.controller.RegisterActivity;
import com.tpc.murphycampus.dao.ErrandDao;
import com.tpc.murphycampus.dao.UserDao;
import com.tpc.murphycampus.dao.impl.ErrandDaoImpl;
import com.tpc.murphycampus.dao.impl.UserDaoImpl;
import com.tpc.murphycampus.pojo.Errand;
import com.tpc.murphycampus.pojo.User;

public class MyFragmentUpload extends Fragment {

    private ErrandDao errandDao;
    private TextView PublisherName;
    private TextView price;
    private TextView pickUpAddress;
    private TextView details;
    private TextView addressee;
    private TextView addresseePhone;
    private TextView shippingAddress;
    private Button btn;
    private int uid;
    private SharedPreferences sharedPreferences;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main_upload, container, false);
        errandDao = new ErrandDaoImpl(getContext());

        PublisherName = view.findViewById(R.id.PublisherName);
        price = view.findViewById(R.id.price);
        pickUpAddress = view.findViewById(R.id.pickUpAddress);
        details = view.findViewById(R.id.details);
        addressee = view.findViewById(R.id.addressee);
        addresseePhone = view.findViewById(R.id.addresseePhone);
        shippingAddress = view.findViewById(R.id.shippingAddress);
        btn = view.findViewById(R.id.btn_upload);

        sharedPreferences = getActivity().getSharedPreferences("userInfo",MODE_PRIVATE);
        uid = sharedPreferences.getInt("userUid",0);
        System.out.println(uid);

        Errand errand = new Errand();

        errandDao = new ErrandDaoImpl(getContext());

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                errand.setDetails(details.getText().toString());
                errand.setPrice(price.getText().toString());
                errand.setPickUpAddress(pickUpAddress.getText().toString());
                errand.setDetails(details.getText().toString());
                errand.setAddressee(addressee.getText().toString());
                errand.setStatus("待接单");
                errand.setAddresseePhone(addresseePhone.getText().toString());
                errand.setShippingAddress(shippingAddress.getText().toString());
                errand.setPublisherId(uid);
                errandDao.insertAll(errand);
                Toast.makeText(getContext(),"发布成功",Toast.LENGTH_LONG).show();
                clean();
            }
        });

        return view;
    }


    public void clean(){
        PublisherName.setText("");
        price.setText("");
        pickUpAddress.setText("");
        details.setText("");
        addressee.setText("");
        addresseePhone.setText("");
        shippingAddress.setText("");
    }


}
