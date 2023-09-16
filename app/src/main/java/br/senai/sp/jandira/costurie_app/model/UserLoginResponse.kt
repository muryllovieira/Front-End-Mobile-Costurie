package br.senai.sp.jandira.costurie_app.model

import com.google.gson.annotations.SerializedName

data class UserLoginResponse(
    @SerializedName("login") val login: UserResponse,
    @SerializedName("status") val status: Int,
    @SerializedName("token") val token: String
)
