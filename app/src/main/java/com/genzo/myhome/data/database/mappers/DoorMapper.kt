package com.genzo.myhome.data.database.mappers

import com.genzo.myhome.data.datasources.entities.Door
import com.genzo.myhome.data.repositories.enitities.Door as DbDoor

object DoorMapper {
    fun map(door: Door): DbDoor {
        return DbDoor(
            id = door.id,
            title = door.name,
            snapshot = door.snapshot,
            room = door.room,
            locked = false,
            favorites = door.favorites,
        )
    }

    fun map(dbDoor: DbDoor): Door {
        return Door(
            id = dbDoor.id,
            name = dbDoor.title,
            favorites = dbDoor.favorites,
            room = dbDoor.room,
            snapshot = dbDoor.snapshot,
        )
    }
}
