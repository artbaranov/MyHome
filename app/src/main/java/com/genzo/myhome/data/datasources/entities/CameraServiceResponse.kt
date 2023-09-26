package com.genzo.myhome.data.datasources.entities

import com.google.gson.annotations.SerializedName

data class CameraServiceResponse(
    val success: Boolean,
    val data: CameraServiceData
)

data class DoorsServiceResponse(
    val success: Boolean,
    @SerializedName("data") val doors: ArrayList<Door>
)

class CameraServiceData(
    val room: ArrayList<String>,
    val cameras: ArrayList<Camera>,
)
