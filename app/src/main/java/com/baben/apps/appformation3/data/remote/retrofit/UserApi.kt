package com.baben.apps.appformation3.data.remote.retrofit

import com.baben.apps.appformation3.data.remote.models.UserDto
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

// Define LoginRequest class
data class LoginRequest(val username: String, val password: String)

// Define LoginResponse class (assuming it's used)
data class LoginResponse(val token: String)

interface UserApi {
    // login
    @GET("users")
    suspend fun getUsers(): List<UserDto>

    @POST("auth/login")
    suspend fun login(@Body loginRequest: LoginRequest): LoginResponse

    // singUp
    //TODO :: add SignUp services here
}
