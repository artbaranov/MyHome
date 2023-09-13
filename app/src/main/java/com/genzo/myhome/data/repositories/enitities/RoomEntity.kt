package com.genzo.myhome.data.repositories.enitities

import com.genzo.myhome.data.datasources.entities.Camera
import io.realm.RealmList
import io.realm.annotations.Required
import io.realm.kotlin.types.RealmObject
import io.realm.kotlin.types.annotations.PrimaryKey

open class RoomEntity() : RealmObject {
    @PrimaryKey
    var id: Int = 0

    @Required
    var name: String = ""
    
    @Required
    var cameras: RealmList<Camera> = RealmList<Camera>()
}
