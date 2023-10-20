package br.senai.sp.jandira.costurie_app.model

import com.google.gson.annotations.SerializedName

data class UsersResponse(
    @SerializedName("usuarios") val usuarios: UsersTagResponse
)
