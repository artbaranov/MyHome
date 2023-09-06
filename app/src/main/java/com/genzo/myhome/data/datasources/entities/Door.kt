package com.genzo.myhome.data.datasources.entities

data class Door(
    val name: String,
    val room: String,
    val id: Int,
    val favorites: Boolean,
    val snapshot: String,
)
