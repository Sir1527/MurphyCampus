package com.tpc.murphycampus.controller;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.tpc.murphycampus.R;
import com.tpc.murphycampus.dao.UserDao;
import com.tpc.murphycampus.dao.impl.UserDaoImpl;
import com.tpc.murphycampus.pojo.User;
import com.tpc.murphycampus.utils.StatusBar;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegisterActivity extends AppCompatActivity {

    private EditText email,userName,phone,passWord,passWord1;
    private Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        StatusBar statusBar = new StatusBar(RegisterActivity.this);
        statusBar.setColor(R.color.transparent);
        statusBar.setTextColor(false);

        email = findViewById(R.id.et_email);
        userName = findViewById(R.id.et_userName);
        phone = findViewById(R.id.et_userPhone);
        passWord = findViewById(R.id.et_password1);
        passWord1 = findViewById(R.id.et_password2);
        btn = findViewById(R.id.btn_register);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onRegister();
            }
        });
    }

    private void onRegister(){

        UserDao userDao = new UserDaoImpl(getApplicationContext());

        Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);

        String userNameR = userName.getText().toString();
        String emailR = email.getText().toString();

        String ph = phone.getText().toString();
        Pattern pattern1 = Pattern.compile("^1[3,5,7,8,9][0-9]{9}$");
        Matcher matcher1 = pattern1.matcher(ph);
        if (ph.equals("")){
            Toast.makeText(RegisterActivity.this,"联系号码不能为空",Toast.LENGTH_LONG).show();
            return;
        } else if(!matcher1.matches()){
            Toast.makeText(RegisterActivity.this,"联系号码格式不正确",Toast.LENGTH_LONG).show();
            return;
        }

        String p1 = passWord.getText().toString();
        if(p1.equals("")){
            Toast.makeText(RegisterActivity.this,"密码不能为空",Toast.LENGTH_LONG).show();
            return;
        }else if(p1.trim().length()<6||p1.trim().length()>12){
            Toast.makeText(RegisterActivity.this,"密码的长度必须为6到12位",Toast.LENGTH_LONG).show();
            return;
        }

        String p2 = passWord1.getText().toString();

        if (p2.equals("")){
            Toast.makeText(RegisterActivity.this,"确认密码不能为空",Toast.LENGTH_LONG).show();
            return;
        } else if(!p2.equals(p1)){
            Toast.makeText(RegisterActivity.this,"两次密码必须一致",Toast.LENGTH_LONG).show();
            return;
        }else {
            intent.putExtra("email",emailR);
            intent.putExtra("passWord",p2);

            User user = new User();
            user.setName(userNameR);
            user.setEmail(emailR);
            user.setPhone(ph);
            user.setPassword(p2);
            userDao.insertAll(user);
        }
        startActivity(intent);
    }
}