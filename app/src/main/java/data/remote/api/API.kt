package data.remote.api

import data.model.UserRequest
import data.model.UserResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface API {
    @POST("login")
        fun login(
            @Body userRequest: UserRequest
    ): Call<UserResponse>
    }
