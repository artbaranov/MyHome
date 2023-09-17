package com.genzo.myhome.data.repositories

import com.genzo.myhome.data.database.dao.DoorsDao
import com.genzo.myhome.data.database.mappers.CameraMapper
import com.genzo.myhome.data.database.mappers.DoorMapper
import com.genzo.myhome.data.datasources.entities.Camera
import com.genzo.myhome.data.datasources.entities.Door
import javax.inject.Inject

interface DoorsLocalRepository {
    suspend fun insertDoor(door: Door)
    suspend fun insertAll(doors: List<Door>)
    suspend fun getAll(): List<Door>
    suspend fun updateDoor(door: Door)
}

class DoorsLocalRepositoryImpl @Inject constructor(
    private val doorsDao: DoorsDao,
) : DoorsLocalRepository {
    override suspend fun insertDoor(door: Door) {
        val dbDoor = DoorMapper.map(door)

        doorsDao.insert(dbDoor)
    }

    override suspend fun insertAll(doors: List<Door>) {
        val dbDoors = doors.map {
            DoorMapper.map(it)
        }

        doorsDao.insertAll(dbDoors)
    }

    override suspend fun getAll(): List<Door> {
        val dbDoors = doorsDao.getAll()

        return dbDoors.map {
            DoorMapper.map(it)
        }
    }

    override suspend fun updateDoor(door: Door) {
        val dbDoor = DoorMapper.map(door)

        doorsDao.update(dbDoor)
    }
}
