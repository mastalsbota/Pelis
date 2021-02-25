package com.mastalsbota.pelis

import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {

    @Before
    fun setUp() {
    }

    @After
    fun tearDown() {
    }

    @Test
    fun addition_isCorrect() {
        runBlocking {
            // GIVEN

            // WHEN

            // THEN
            assertEquals(4, 2 + 2)
        }
    }
}
