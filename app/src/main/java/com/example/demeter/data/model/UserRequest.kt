package com.example.demeter.data.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class UserRequest {
    @SerializedName ("Email")
    var email: String? = null

    @SerializedName("contraseña")
    var contraseña: String? = null
}