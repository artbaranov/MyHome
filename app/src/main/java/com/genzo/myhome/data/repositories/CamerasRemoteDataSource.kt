package com.genzo.myhome.data.repositories

import okhttp3.ResponseBody
import retrofit2.http.GET

interface CamerasRemoteDataSource {

    @GET("/api/rubetek/cameras/")
    suspend fun getCameras(): ResponseBody
}
