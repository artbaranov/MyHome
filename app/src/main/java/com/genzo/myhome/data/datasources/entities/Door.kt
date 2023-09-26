package com.genzo.myhome.data.datasources.entities

data class Door(
    val name: String,
    val room: String?,
    val id: Long,
    val favorites: Boolean,
    val snapshot: String?,
) {
    override fun equals(other: Any?): Boolean {
        if (other !is Door) throw DoorEqualityException()

        return this.id == other.id
    }

    override fun hashCode(): Int {
        var result = name.hashCode()
        result = 31 * result + (room?.hashCode() ?: 0)
        result = 31 * result + id.hashCode()
        return result
    }
}

class DoorEqualityException : Exception()
