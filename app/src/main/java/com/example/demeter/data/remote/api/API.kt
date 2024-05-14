package com.example.demeter.data.remote.api

import com.example.demeter.data.model.UserRequest
import com.example.demeter.data.model.UserResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface API {
    @POST("login")
        fun login(
            @Body userRequest: UserRequest
    ): Call<UserResponse>
    }
