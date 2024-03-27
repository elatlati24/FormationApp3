package com.baben.apps.appformation3.data.remote.retrofit

import com.baben.apps.appformation3.data.remote.models.UserDto
import retrofit2.http.GET
interface UserApi {
    // login
    @GET("users")
    suspend fun getUsers(): List<UserDto>

    // singUp
    //TODO :: add Login and SingUp services here
}