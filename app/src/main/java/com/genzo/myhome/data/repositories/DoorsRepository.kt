package com.genzo.myhome.data.repositories

import com.genzo.myhome.data.entities.Door
import kotlinx.coroutines.delay

interface DoorsRepository {
    suspend fun getDoors(): List<Door>
}

class FakeDoorsRepository : DoorsRepository {
    override suspend fun getDoors(): List<Door> {
        val testList = arrayListOf<Door>()

        repeat(3) {
            delay(5)
            testList += Door(
                name = "Door 1",
                snapshot = "",
                room = "Room 1",
                id = 1,
                favorites = true,
            )
        }

        testList += Door(
            name = "Door 1",
            snapshot = "https://serverspace.ru/wp-content/uploads/2019/06/backup-i-snapshot.png",
            room = "Room 1",
            id = 1,
            favorites = false,
        )

        return testList
    }
}
