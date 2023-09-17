package com.genzo.myhome.data.database

import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase

val Migration_3_4 = object : Migration(3, 4) {

    override fun migrate(database: SupportSQLiteDatabase) {
        database.execSQL("ALTER TABLE cameras ADD COLUMN recording INTEGER NOT NULL DEFAULT 0")
    }
}

val allMigrations = arrayOf(
    Migration_3_4,
)
