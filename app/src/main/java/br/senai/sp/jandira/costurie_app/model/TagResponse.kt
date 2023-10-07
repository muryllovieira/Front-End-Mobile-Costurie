package br.senai.sp.jandira.costurie_app.model

import com.google.gson.annotations.SerializedName

data class TagResponse(
    val id: Int,
    @SerializedName("nome") val nome_tag: String,
)
