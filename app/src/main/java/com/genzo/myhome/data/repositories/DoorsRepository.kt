package com.genzo.myhome.data.repositories

import com.genzo.myhome.data.datasources.DoorsRemoteDataSource
import com.genzo.myhome.data.datasources.entities.Door
import com.genzo.myhome.data.repositories.local.DoorsLocalRepository
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import javax.inject.Inject

interface DoorsRepository {
    val events: SharedFlow<RepositoryEvent>

    suspend fun provideDoors(): List<Door>
    suspend fun updateDoor(door: Door)
}

class DoorsRepositoryImpl @Inject constructor(
    private val doorsLocalRepository: DoorsLocalRepository,
    private val doorsRemoteDataSource: DoorsRemoteDataSource,
) : DoorsRepository {
    private val _events = MutableSharedFlow<RepositoryEvent>()
    override val events: SharedFlow<RepositoryEvent> = _events.asSharedFlow()

    override suspend fun provideDoors(): List<Door> {
        val doorsFromLocalRepository = doorsLocalRepository.getAll()

        if (doorsFromLocalRepository.isNotEmpty()) return doorsFromLocalRepository

        val response = doorsRemoteDataSource.getDoors()

        if (!response.success) throw RequestFailed()

        val doorsFromRemoteSource = response.doors

        doorsLocalRepository.insertAll(doorsFromRemoteSource)

        return doorsFromRemoteSource
    }

    override suspend fun updateDoor(door: Door) {
        doorsLocalRepository.updateDoor(door)
    }
}
