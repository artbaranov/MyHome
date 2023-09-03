package com.genzo.myhome.data.repositories

import retrofit2.http.GET

interface DoorsRepository {
    @GET("/api/rubetek/doors/")
    suspend fun getCameras(): List<Door>
}