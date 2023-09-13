package com.genzo.myhome.data.repositories.enitities

import io.realm.kotlin.Realm

interface RoomRepository {
    suspend fun createRoom()
    suspend fun readRoom(id: Int)
    suspend fun updateRoom(id: Int)
    suspend fun deleteRoom(id: Int)

}

class RoomRepositoryImpl(realm: Realm) {

}
