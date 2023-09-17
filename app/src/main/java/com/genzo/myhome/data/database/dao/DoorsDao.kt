package com.genzo.myhome.data.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.genzo.myhome.data.repositories.enitities.Door

@Dao
interface DoorsDao {
    @Insert
    fun insert(door: Door)

    @Insert
    fun insertAll(doors: List<Door>)

    @Query("SELECT * FROM doors")
    fun getAll(): List<Door>

    @Update
    fun update(door: Door)
}
