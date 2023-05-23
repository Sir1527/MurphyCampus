package com.tpc.murphycampus.controller;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.tpc.murphycampus.R;
import com.tpc.murphycampus.dao.UserDao;
import com.tpc.murphycampus.dao.impl.UserDaoImpl;
import com.tpc.murphycampus.pojo.User;
import com.tpc.murphycampus.utils.StatusBar;

public class updateUserActivity extends AppCompatActivity {

    private SharedPreferences sharedPreferences;
    private UserDao userDao;
    private TextView name;
    private TextView phone;
    private TextView passWord;
    private TextView passWord2;
    private TextView address;
    private Button btn;
    private int uid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_updata_user);

        StatusBar statusBar = new StatusBar(updateUserActivity.this);
        statusBar.setColor(R.color.transparent);
        statusBar.setTextColor(false);

        sharedPreferences = updateUserActivity.this.getSharedPreferences("userInfo",MODE_PRIVATE);
        uid = sharedPreferences.getInt("userUid",0);

        userDao = new UserDaoImpl(getApplicationContext());
        User user = userDao.findByUid(uid);

        name = findViewById(R.id.Name);
        phone = findViewById(R.id.phone);
        passWord = findViewById(R.id.pwd);
        passWord2 = findViewById(R.id.pwd2);
        address = findViewById(R.id.address);
        btn = findViewById(R.id.button);

        name.setText(user.getName());
        phone.setText(user.getPhone());

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userName = name.getText().toString();
                String userPhone = phone.getText().toString();
                String pwd1 = passWord.getText().toString();
                String pwd2 = passWord2.getText().toString();
                String userAddress = address.getText().toString();


                /* 判断密码是否为空，长度是否大于6位小于12位 */
                if(pwd1.equals("")){
                    Toast.makeText(updateUserActivity.this,"密码不能为空",Toast.LENGTH_LONG).show();
                    return;
                }else if(pwd1.trim().length() < 6 || pwd1.trim().length() > 12){
                    Toast.makeText(updateUserActivity.this,"密码的长度必须为6到12位",Toast.LENGTH_LONG).show();
                    return;
                }

                if (pwd2.equals("")){
                    Toast.makeText(updateUserActivity.this,"确认密码不能为空",Toast.LENGTH_LONG).show();
                    return;
                } else if(!pwd2.equals(pwd1)){
                    Toast.makeText(updateUserActivity.this,"两次密码必须一致",Toast.LENGTH_LONG).show();
                    return;
                }else {

                    User userModify = new User();
                    userModify.setUid(uid);
                    userModify.setName(userName);
                    userModify.setPhone(userPhone);
                    userModify.setPassword(pwd2);
                    userModify.setAddress(userAddress);
                    userDao.upDateUser(userModify);
                    Toast.makeText(updateUserActivity.this,"修改成功！",Toast.LENGTH_LONG).show();
                }

            }
        });

    }
}