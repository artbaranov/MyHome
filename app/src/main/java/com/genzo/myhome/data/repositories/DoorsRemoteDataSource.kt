package com.genzo.myhome.data.repositories

import com.genzo.myhome.data.entities.Door
import retrofit2.http.GET

interface DoorsRemoteDataSource {
    @GET("/api/rubetek/doors/")
    suspend fun getDoors(): List<Door>
}
