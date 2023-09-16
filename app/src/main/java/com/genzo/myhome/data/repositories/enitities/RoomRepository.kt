package com.genzo.myhome.data.repositories.enitities

import com.genzo.myhome.data.database.dao.RoomDao
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.asSharedFlow

interface RoomRepository {
    val events: SharedFlow<RepositoryEvent>
    suspend fun add(room: Room): Room
    suspend fun loadAll(): List<Room>

    object Events {
        data class RoomAdded(val room: Room) : RepositoryEvent
        data class RoomUpdated(val room: Room) : RepositoryEvent
        data class RoomDeleted(val room: Room) : RepositoryEvent
    }
}

interface RepositoryEvent


class RoomRepositoryImpl(
    private val dao: RoomDao,
    private val camerasRepository: CamerasRepository,
) : RoomRepository {

    private val _events = MutableSharedFlow<RepositoryEvent>()
    override val events: SharedFlow<RepositoryEvent> = _events.asSharedFlow()

    override suspend fun add(room: Room): Room {
        val dbRoom = RoomMapper.map(room)

        val insertedRowId = dao.insert(dbTransaction)

        val addedRoom = room.copy(id = insertedRowId)

        _events.emit(RoomRepository.Events.RoomAdded(addedRoom))

        return addedRoom
    }

    override suspend fun loadAll(): List<Room> {
        return dao.getAll();
    }
}




