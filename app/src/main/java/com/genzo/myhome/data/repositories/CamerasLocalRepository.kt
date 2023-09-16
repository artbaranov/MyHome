package com.genzo.myhome.data.repositories

import com.genzo.myhome.data.database.dao.CamerasDao
import com.genzo.myhome.data.database.mappers.CameraMapper
import com.genzo.myhome.data.datasources.entities.Camera
import javax.inject.Inject

interface CamerasLocalRepository {
    suspend fun insertCamera(camera: Camera)
    suspend fun getAllCameras(): List<Camera>
}

class CamerasLocalRepositoryImpl @Inject constructor(private val camerasDao: CamerasDao) : CamerasLocalRepository {
    override suspend fun insertCamera(camera: Camera) {
        val dbCamera = CameraMapper.map(camera)
        camerasDao.insert(dbCamera)
    }

    override suspend fun getAllCameras(): List<Camera> {
        val dbCameras = camerasDao.getAll()

        return dbCameras.map {
            CameraMapper.map(it)
        }
    }
}




