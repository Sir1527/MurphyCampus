package com.tpc.murphycampus.dao.impl;

import android.content.Context;

import com.tpc.murphycampus.dao.ErrandDao;
import com.tpc.murphycampus.dao.UserDao;
import com.tpc.murphycampus.db.DbManager;
import com.tpc.murphycampus.pojo.Errand;

import java.util.ArrayList;
import java.util.List;

public class ErrandDaoImpl implements ErrandDao {

    private Context context;
    private ErrandDao errandDao;

    public ErrandDaoImpl(Context context) {
        this.context = context;
        DbManager.getInstance().init(context);
        errandDao = DbManager.getInstance().getErrandDao();
    }

    @Override
    public void insertAll(Errand... errands) {
        errandDao.insertAll(errands);
    }

    @Override
    public List<Errand> getAll() {
        return errandDao.getAll();
    }

    @Override
    public List<Errand> getStatusByPending(String status) {
        return errandDao.getStatusByPending(status);
    }

    @Override
    public List<Errand> getStatusByByPublisherId(int id) {
        return errandDao.getStatusByByPublisherId(id);
    }

    @Override
    public List<Errand> getByAcceptIdAndStatus(int id, String status) {
        return errandDao.getByAcceptIdAndStatus(id,status);
    }


    @Override
    public List<Errand> getStatusByPendingByPublisherId(String status, int id) {
        return errandDao.getStatusByPendingByPublisherId(status,id);
    }

    @Override
    public void updateErrandByAcceptId(Errand errand) {
        errandDao.updateErrandByAcceptId(errand);
    }
}
