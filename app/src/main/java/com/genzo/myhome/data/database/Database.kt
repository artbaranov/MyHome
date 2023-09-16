package com.genzo.myhome.data.database

import androidx.room.AutoMigration
import androidx.room.Database
import androidx.room.RoomDatabase
import com.genzo.myhome.data.database.dao.CamerasDao
import com.genzo.myhome.data.database.dao.DoorsDao
import com.genzo.myhome.data.repositories.enitities.Camera
import com.genzo.myhome.data.repositories.enitities.Door

@Database(
    entities = [Camera::class, Door::class],
    version = 3,
    exportSchema = true,
    autoMigrations = [AutoMigration(from = 2, to = 3)]
)
abstract class Database : RoomDatabase() {
    abstract fun camerasDao(): CamerasDao
    abstract fun doorsDao(): DoorsDao
}
