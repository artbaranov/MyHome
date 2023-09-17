package com.genzo.myhome.data.repositories.enitities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "cameras")
data class Camera(
    @PrimaryKey(autoGenerate = true)
    val id: Long,
    val title: String,
    val favorite: Boolean,
    val guarded: Boolean,
    val snapshot: String,
    val room: String?,
    val recording: Boolean,
)
