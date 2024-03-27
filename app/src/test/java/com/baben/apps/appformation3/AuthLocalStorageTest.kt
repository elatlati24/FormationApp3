package com.baben.apps.appformation3

import com.baben.apps.appformation3.core.app.AuthLocalStorage
import org.junit.Test

import org.junit.Assert.*
import org.junit.Before

class AuthLocalStorageTest {

    private lateinit var authLocalStorage: AuthLocalStorage

    @Before
    fun setup() {
        authLocalStorage = AuthLocalStorage()
    }

    @Test
    fun testSetToken() {
        val token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOjEsInVzZXIiOiJqb2huZCIsImlhdCI6MTcxMTU0MTk1N30.CCpL3T5GyRVG5f1QNDUd1HuU7vVLO6SIJlomU_zVYV4"
        authLocalStorage.setToken(token)
        assertEquals(token, authLocalStorage.getToken())
    }

    @Test
    fun testGetToken() {
        val token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOjEsInVzZXIiOiJqb2huZCIsImlhdCI6MTcxMTU0MTk1N30.CCpL3T5GyRVG5f1QNDUd1HuU7vVLO6SIJlomU_zVYV4"
        authLocalStorage.setToken(token)
        assertEquals(token, authLocalStorage.getToken())
    }

    @Test
    fun testIsLoggedIn() {
        assertFalse(authLocalStorage.isLoggedIn())
        authLocalStorage.setToken("eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOjEsInVzZXIiOiJqb2huZCIsImlhdCI6MTcxMTU0MTk1N30.CCpL3T5GyRVG5f1QNDUd1HuU7vVLO6SIJlomU_zVYV4")
        assertTrue(authLocalStorage.isLoggedIn())
    }
}
