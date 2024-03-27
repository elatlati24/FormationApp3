package com.baben.apps.appformation3.data.remote.repositories

import com.baben.apps.appformation3.domain.models.Login

import com.baben.apps.appformation3.domain.models.User
import com.baben.apps.appformation3.domain.repositories.LoginRepository
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

class ApiLoginRepository : LoginRepository {

    private val api: FakeStoreApi

    init {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://fakestoreapi.com")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        api = retrofit.create(FakeStoreApi::class.java)
    }

    override fun login(model: Login?): LoginRepository.LoginResult? {
        TODO("Not yet implemented")
    }

    interface FakeStoreApi {
//        @POST("/auth/login")
//        suspend fun login(@Body loginRequest: Login): LoginResponse

        @GET("/users/{userId}")
        suspend fun getUser(@Path("userId") userId: Int): User
    }


}
