package com.genzo.myhome.di

import android.content.Context
import androidx.room.Room
import com.genzo.myhome.data.database.Database
import com.genzo.myhome.data.database.allMigrations
import com.genzo.myhome.data.database.dao.CamerasDao
import com.genzo.myhome.data.database.dao.DoorsDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    fun provideDatabase(@ApplicationContext context: Context): Database {
        return Room
            .databaseBuilder(
                context,
                Database::class.java,
                "myHome"
            )
            .addMigrations(*allMigrations)
            .build()
    }

    @Provides
    fun provideCamerasDao(database: Database): CamerasDao {
        return database.camerasDao()
    }

    @Provides
    fun provideDoorsDao(database: Database): DoorsDao {
        return database.doorsDao()
    }
}
