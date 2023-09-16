package com.genzo.myhome.data.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.genzo.myhome.data.repositories.enitities.Door

@Dao
interface DoorsDao {
    @Insert
    suspend fun insert(door: Door)

    @Query("SELECT * FROM doors")
    suspend fun getAll(): List<Door>
}
