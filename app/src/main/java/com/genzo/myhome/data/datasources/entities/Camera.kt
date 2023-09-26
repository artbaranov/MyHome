package com.genzo.myhome.data.datasources.entities

import com.google.gson.annotations.SerializedName

data class Camera(
    val name: String,
    val snapshot: String,
    val room: String?,
    val id: Long,
    @SerializedName("favorites") val favorite: Boolean,
    @SerializedName("rec") val recording: Boolean,
)
