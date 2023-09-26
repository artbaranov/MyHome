package com.genzo.myhome.data.datasources

import com.genzo.myhome.data.datasources.entities.CameraServiceResponse
import retrofit2.http.GET


interface CamerasRemoteDataSource {

    @GET("/api/rubetek/cameras/")
    suspend fun getCameras(): CameraServiceResponse
}
