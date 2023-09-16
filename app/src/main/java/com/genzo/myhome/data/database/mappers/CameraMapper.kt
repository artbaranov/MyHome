package com.genzo.myhome.data.database.mappers

import com.genzo.myhome.data.datasources.entities.Camera
import com.genzo.myhome.data.repositories.enitities.Camera as dbCamera

object CameraMapper {
    fun map(camera: Camera): dbCamera {
        return dbCamera(
            id = camera.id,
            favorite = camera.favorites,
            guarded = false,
            room = camera.room,
            snapshot = camera.snapshot,
            title = camera.name,
        )
    }

    fun map(camera: dbCamera): Camera {
        return Camera(
            id = camera.id,
            name = camera.title,
            favorites = camera.favorite,
            room = camera.room,
            snapshot = camera.snapshot,
            rec = false,
        )
    }
}
