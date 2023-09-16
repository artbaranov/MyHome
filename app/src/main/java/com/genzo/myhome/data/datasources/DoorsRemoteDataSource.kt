package com.genzo.myhome.data.datasources

import com.genzo.myhome.data.datasources.entities.DoorsServiceResponse
import retrofit2.http.GET

interface DoorsRemoteDataSource {
    @GET("/api/rubetek/doors/")
    suspend fun getDoors(): DoorsServiceResponse
}
