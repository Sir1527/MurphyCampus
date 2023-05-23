package com.tpc.murphycampus.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.tpc.murphycampus.pojo.Errand;

import java.util.ArrayList;
import java.util.List;

@Dao
public interface ErrandDao {
    @Insert
    void insertAll(Errand... errands);

    @Query("SELECT * FROM errand")
    List<Errand> getAll();

    @Query("SELECT * FROM errand WHERE status = :status")
    List<Errand> getStatusByPending(String status);

    @Query("SELECT * FROM errand WHERE PublisherId = :id")
    List<Errand> getStatusByByPublisherId(int id);

    @Query("SELECT * FROM errand WHERE acceptId = :id AND status = :status")
    List<Errand> getByAcceptIdAndStatus(int id,String status);

    @Query("SELECT * FROM errand WHERE status = :status AND PublisherId = :id")
    List<Errand> getStatusByPendingByPublisherId(String status,int id);

    @Update
    void  updateErrandByAcceptId(Errand errand);


}
