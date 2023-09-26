package com.genzo.myhome.data.repositories

import com.genzo.myhome.data.datasources.DoorsRemoteDataSource
import com.genzo.myhome.data.datasources.entities.Door
import com.genzo.myhome.data.repositories.local.DoorsLocalRepository
import javax.inject.Inject

interface DoorsRepository {
    suspend fun provideDoors(): List<Door>
    suspend fun updateDoor(door: Door)
}

class DoorsRepositoryImpl @Inject constructor(
    private val doorsLocalRepository: DoorsLocalRepository,
    private val doorsRemoteDataSource: DoorsRemoteDataSource,
) : DoorsRepository {

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
