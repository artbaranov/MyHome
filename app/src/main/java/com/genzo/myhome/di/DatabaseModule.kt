package com.genzo.myhome.di

import android.content.Context
import androidx.room.Room
import com.genzo.myhome.data.database.Database
import com.genzo.myhome.data.database.dao.CamerasDao
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
        return Room.databaseBuilder(
            context,
            Database::class.java,
            "myHome"
        ).build()
    }

    @Provides
    fun provideCameraDao(database: Database): CamerasDao {
        return database.camerasDao()
    }
}
