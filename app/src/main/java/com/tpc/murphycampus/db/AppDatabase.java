package com.tpc.murphycampus.db;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.tpc.murphycampus.dao.ErrandDao;
import com.tpc.murphycampus.dao.UserDao;
import com.tpc.murphycampus.pojo.Errand;
import com.tpc.murphycampus.pojo.User;

@Database(entities = {User.class,Errand.class}, version = 7,exportSchema=false)
public abstract class AppDatabase extends RoomDatabase {
    public abstract UserDao userDao();

    abstract ErrandDao errandDao();
}