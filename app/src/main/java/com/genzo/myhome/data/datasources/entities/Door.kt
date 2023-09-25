package com.genzo.myhome.data.datasources.entities

data class Door(
    val name: String,
    val room: String?,
    val id: Long,
    val favorites: Boolean,
    val snapshot: String?,
) {
    override fun equals(other: Any?): Boolean {
        if (other !is Door) throw Exception()

        return this.id == other.id
    }
}
