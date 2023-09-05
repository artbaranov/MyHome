package com.genzo.myhome.data.repositories

import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Test

class CamerasRepositoriesUnitTests {

    private lateinit var sut: CamerasRemoteDataSource

    @Before
    fun `set up`() {
        sut = FakeCamerasRepository()
    }

    @Test
    fun `getCameras returns a list of cameras`() = runTest {
        val cameras = sut.sendRequest()

        assertEquals(20, cameras.size)
    }
}
