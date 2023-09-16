package com.genzo.myhome.data.repositories.enitities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "doors")
data class Door(
    @PrimaryKey(autoGenerate = true)
    val id: Long,
    val title: String,
    val snapshot: String,
    val favorites: Boolean,
    val locked: Boolean,
    val  room: String?,
)
