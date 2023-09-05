package com.genzo.myhome.data.repositories

import com.genzo.myhome.data.entities.CameraServiceResponse
import retrofit2.http.GET


interface CamerasRemoteDataSource {

    @GET("/api/rubetek/cameras/")
    suspend fun sendRequest(): CameraServiceResponse
}
