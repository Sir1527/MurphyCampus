package com.tpc.murphycampus.db;

import android.content.Context;

import androidx.room.Room;

import com.tpc.murphycampus.dao.ErrandDao;
import com.tpc.murphycampus.dao.UserDao;

public class DbManager {

    private static DbManager instance;
    private AppDatabase myDataBase;

    public static DbManager getInstance() {
        if (instance == null) {
            synchronized (DbManager.class) {
                if (instance == null) {
                    instance = new DbManager();
                }
            }
        }
        return instance;
    }

    public void init(Context context) {
        myDataBase = Room.databaseBuilder(context, AppDatabase.class, "School")
                .allowMainThreadQueries()
                .fallbackToDestructiveMigration()
//				.addMigrations(migration)
                .build();
    }

    //返回对应的DAO实体类
    public UserDao getUserDao() {
        return myDataBase.userDao();
    }

    public ErrandDao getErrandDao() {
        return myDataBase.errandDao();
    }
}
