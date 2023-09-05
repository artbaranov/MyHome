package com.genzo.myhome.data.entities

data class CameraServiceResponse(
    val success: Boolean,
    val data: CameraServiceData
)

data class DoorsServiceResponse(
    val success: Boolean,
    val data: ArrayList<Door>
)

class CameraServiceData(
    val room: ArrayList<String>,
    val cameras: ArrayList<Camera>,
)
