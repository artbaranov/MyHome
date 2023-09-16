package com.genzo.myhome.data.database.mappers

import com.genzo.myhome.data.datasources.entities.Camera
import com.genzo.myhome.data.repositories.enitities.Camera as DbCamera

object CameraMapper {
    fun map(camera: Camera): DbCamera {
        return DbCamera(
            id = camera.id,
            favorite = camera.favorites,
            guarded = false,
            room = camera.room,
            snapshot = camera.snapshot,
            title = camera.name,
        )
    }

    fun map(dbCamera: DbCamera): Camera {
        return Camera(
            id = dbCamera.id,
            name = dbCamera.title,
            favorites = dbCamera.favorite,
            room = dbCamera.room,
            snapshot = dbCamera.snapshot,
            rec = false,
        )
    }
}
