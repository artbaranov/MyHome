package com.genzo.myhome.data.providers

import com.genzo.myhome.data.datasources.CamerasRemoteDataSource
import com.genzo.myhome.data.datasources.entities.Camera
import com.genzo.myhome.data.repositories.CamerasLocalRepository
import javax.inject.Inject

interface CamerasProvider {
    suspend fun provideCameras(): List<Camera>
    suspend fun updateCamera(camera: Camera)
}

class CamerasProviderImpl @Inject constructor(
    private val camerasLocalRepository: CamerasLocalRepository,
    private val camerasRemoteDataSource: CamerasRemoteDataSource,
) : CamerasProvider {
    override suspend fun provideCameras(): List<Camera> {
        val camerasFromLocalRepository = camerasLocalRepository.getAll()

        if (camerasFromLocalRepository.isNotEmpty()) return camerasFromLocalRepository

        val response = camerasRemoteDataSource.getCameras()

        if (!response.success) throw RequestFailed()

        val camerasFromRemoteSource = response.data.cameras

        camerasLocalRepository.insertAll(camerasFromRemoteSource)

        return camerasFromRemoteSource
    }

    override suspend fun updateCamera(camera: Camera) {
        camerasLocalRepository.updateCamera(camera)
    }
}
