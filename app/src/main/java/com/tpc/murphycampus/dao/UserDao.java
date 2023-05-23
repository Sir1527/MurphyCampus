package com.tpc.murphycampus.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.tpc.murphycampus.pojo.User;

import java.util.List;

@Dao
public interface UserDao {
    @Insert
    void insertAll(User... users);

    @Delete
    void delete(User user);

    @Query("SELECT * FROM user WHERE email = :email AND password = :password")
    User findByEmail(String email,String password);

    @Query("SELECT * FROM user WHERE uid = :id")
    User findByUid(int id);

    @Update
    void upDateUser(User user);
}