package com.genzo.myhome.data.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.genzo.myhome.data.repositories.enitities.Camera

@Dao
interface CamerasDao {
    @Insert
    fun insert(camera: Camera)

    @Insert
    fun insertAll(cameras: List<Camera>)

    @Query("SELECT * FROM cameras")
    fun getAll(): List<Camera>
}
