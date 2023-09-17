package com.genzo.myhome.data.providers

import com.genzo.myhome.data.datasources.DoorsRemoteDataSource
import com.genzo.myhome.data.datasources.entities.Door
import com.genzo.myhome.data.repositories.DoorsLocalRepository
import javax.inject.Inject

interface DoorsProvider {
    suspend fun provideDoors(): List<Door>
    suspend fun updateDoor(door: Door)
}

class DoorsProviderImpl @Inject constructor(
    private val doorsLocalRepository: DoorsLocalRepository,
    private val doorsRemoteDataSource: DoorsRemoteDataSource,
) : DoorsProvider {
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
