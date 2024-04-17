package data.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class UserResponse {
    @SerializedName("data")
    var data: User? = null

    class User {
        @SerializedName ("Email")
        @Expose
        var email: String? = null

        @SerializedName("contraseña")
        @Expose
        var contraseña: String? = null

        @SerializedName("token")
        @Expose
        var token: String? = null
    }
}