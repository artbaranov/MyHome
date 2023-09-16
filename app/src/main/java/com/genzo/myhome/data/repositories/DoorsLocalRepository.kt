package com.genzo.myhome.data.repositories

import com.genzo.myhome.data.database.dao.DoorsDao
import com.genzo.myhome.data.database.mappers.DoorMapper
import com.genzo.myhome.data.datasources.entities.Door
import javax.inject.Inject

interface DoorsLocalRepository {
    suspend fun insertDoor(door: Door)
    suspend fun getAll(): List<Door>
}

class DoorsLocalRepositoryImpl @Inject constructor(
    private val doorsDao: DoorsDao,
) : DoorsLocalRepository {
    override suspend fun insertDoor(door: Door) {
        val dbDoor = DoorMapper.map(door)
        doorsDao.insert(dbDoor)
    }

    override suspend fun getAll(): List<Door> {
        val dbDoors = doorsDao.getAll()

        return dbDoors.map {
            DoorMapper.map(it)
        }
    }
}
