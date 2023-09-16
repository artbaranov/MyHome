package com.genzo.myhome.data.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.genzo.myhome.data.repositories.enitities.Camera

@Dao
interface CamerasDao {
    @Insert
    suspend fun insert(camera: Camera)

    @Query("SELECT * FROM cameras")
    suspend fun getAll(): List<Camera>
}
