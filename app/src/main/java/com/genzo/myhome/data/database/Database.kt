package com.genzo.myhome.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.genzo.myhome.data.database.dao.CamerasDao
import com.genzo.myhome.data.repositories.enitities.Camera

@Database(entities = [Camera::class], version = 1)
abstract class Database : RoomDatabase() {
    abstract fun camerasDao(): CamerasDao
}
