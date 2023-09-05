package com.genzo.myhome.data.entities.repositories

import com.genzo.myhome.data.entities.Camera
import kotlinx.coroutines.delay

interface CamerasRepository {
    suspend fun getCameras(): List<Camera>
}

class FakeCamerasRepository : CamerasRepository {
    override suspend fun getCameras(): List<Camera> {
        val testList = arrayListOf<Camera>()

        repeat(20) {
            delay(5)
            testList += Camera(
                name = "Camera 1",
                snapshot = "https://serverspace.ru/wp-content/uploads/2019/06/backup-i-snapshot.png",
                room = "Room 1",
                id = 1,
                favorites = true,
                rec = true
            )
        }

        return testList
    }
}
