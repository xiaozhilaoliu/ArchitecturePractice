package com.lijiankun24.architecturepractice.db.dao;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import com.lijiankun24.architecturepractice.db.entity.Girl;

import java.util.List;

/**
 * GirlDao.java
 * <p>
 * Created by lijiankun on 17/7/5.
 */

@Dao
public interface GirlDao {

    @Query("SELECT * FROM girls")
    LiveData<List<Girl>> loadAllGirls();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertGirls(List<Girl> girls);

    @Query("SELECT * FROM girls WHERE mId = :id")
    LiveData<Girl> loadGirl(String id);

    @Query("SELECT * FROM girls WHERE mId = :id")
    Girl loadGirlSync(String id);
}