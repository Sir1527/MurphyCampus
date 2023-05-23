package com.tpc.murphycampus.controller;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.tpc.murphycampus.R;
import com.tpc.murphycampus.dao.UserDao;
import com.tpc.murphycampus.dao.impl.UserDaoImpl;
import com.tpc.murphycampus.pojo.Errand;
import com.tpc.murphycampus.pojo.User;
import com.tpc.murphycampus.utils.StatusBar;

public class LoginActivity extends AppCompatActivity {

    private EditText emailText,passwordText;
    private String email = null;
    private String password = null;
    private Button btn;
    private User byEmail;
    private UserDao userDao;
    private SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        StatusBar statusBar = new StatusBar(LoginActivity.this);
        statusBar.setColor(R.color.transparent);
        statusBar.setTextColor(false);

        emailText = findViewById(R.id.email);
        passwordText = findViewById(R.id.password);
        btn = findViewById(R.id.login);

        Intent intent = getIntent();
        String phone = intent.getStringExtra("email");
        emailText.setText(phone);

        String pwd = intent.getStringExtra("passWord");
        passwordText.setText(pwd);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                email = emailText.getText().toString();
                password = passwordText.getText().toString();

                System.out.println(email);
                System.out.println(password);

                if(email.equals("") || email == null){
                    Toast.makeText(getApplicationContext(), "账号不能为空", Toast.LENGTH_SHORT).show();
                }
                else if(password.equals("") || password == null){
                    Toast.makeText(getApplicationContext(), "密码不能为空", Toast.LENGTH_SHORT).show();
                }else {
                    checkUser(email,password);
                }
            }
        });

        View register = findViewById(R.id.textView5);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(intent);
            }
        });

    }

    private void checkUser(String email, String password){
        userDao = new UserDaoImpl(getApplicationContext());
        byEmail = userDao.findByEmail(email, password);
        if (byEmail == null){
            Toast.makeText(getApplicationContext(), "账号密码错误", Toast.LENGTH_SHORT).show();
        }else {
            Intent intent = new Intent(LoginActivity.this,MainActivity.class);
            System.out.println("用户名:"+byEmail.getName());
            sharedPreferences = this.getSharedPreferences("userInfo", Context.MODE_PRIVATE);
            SharedPreferences.Editor editor=sharedPreferences.edit();
            editor.putInt("userUid",byEmail.getUid());
            editor.commit();
            byEmail = null;
            startActivity(intent);
        }
    }
}