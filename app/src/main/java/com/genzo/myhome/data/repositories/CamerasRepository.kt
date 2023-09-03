package com.genzo.myhome.data.repositories

import retrofit2.http.GET

interface CamerasRepository {

    @GET("/api/rubetek/cameras/")
    suspend fun getCameras(): List<Camera>
}