package com.genzo.myhome.data.repositories

import com.genzo.myhome.data.database.dao.CamerasDao
import com.genzo.myhome.data.database.mappers.CameraMapper
import com.genzo.myhome.data.datasources.entities.Camera

interface CamerasLocalRepository {
    suspend fun insertCamera(camera: Camera)
}

class CamerasLocalRepositoryImpl(private val camerasDao: CamerasDao) : CamerasLocalRepository {
    override suspend fun insertCamera(camera: Camera) {
        val dbCamera = CameraMapper.map(camera)
        camerasDao.insert(dbCamera)
    }
}




