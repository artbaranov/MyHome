package com.genzo.myhome.data.repositories.local

import com.genzo.myhome.data.database.dao.CamerasDao
import com.genzo.myhome.data.database.mappers.CameraMapper
import com.genzo.myhome.data.datasources.entities.Camera
import javax.inject.Inject

interface CamerasLocalRepository {
    suspend fun insertCamera(camera: Camera)
    suspend fun getAll(): List<Camera>
    suspend fun insertAll(cameras: List<Camera>)
    suspend fun updateCamera(camera: Camera)
}

class CamerasLocalRepositoryImpl @Inject constructor(
    private val camerasDao: CamerasDao
) : CamerasLocalRepository {
    override suspend fun insertCamera(camera: Camera) {
        val dbCamera = CameraMapper.map(camera)
        camerasDao.insert(dbCamera)
    }

    override suspend fun getAll(): List<Camera> {
        val dbCameras = camerasDao.getAll()

        return dbCameras.map {
            CameraMapper.map(it)
        }
    }

    override suspend fun insertAll(cameras: List<Camera>) {
        val dbCameras = cameras.map {
            CameraMapper.map(it)
        }

        camerasDao.insertAll(dbCameras)
    }

    override suspend fun updateCamera(camera: Camera) {
        val dbCamera = CameraMapper.map(camera)
        camerasDao.update(dbCamera)
    }
}




