package com.tpc.murphycampus.dao.impl;

import android.content.Context;

import com.tpc.murphycampus.dao.UserDao;
import com.tpc.murphycampus.db.DbManager;
import com.tpc.murphycampus.pojo.User;

import java.util.List;

public class UserDaoImpl implements UserDao {

    private UserDao userDao;
    private Context context;

    public UserDaoImpl(Context context) {
        this.context = context;
        DbManager.getInstance().init(context);
        userDao = DbManager.getInstance().getUserDao();
    }


    @Override
    public void insertAll(User... users) {
        userDao.insertAll(users);
    }

    @Override
    public void delete(User user) {
        userDao.delete(user);
    }

    @Override
    public User findByEmail(String email, String password) {
        return userDao.findByEmail(email,password);
    }

    @Override
    public User findByUid(int id) {
        return userDao.findByUid(id);
    }

    @Override
    public void upDateUser(User user) {
        userDao.upDateUser(user);
    }

}
