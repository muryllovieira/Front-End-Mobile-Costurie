package br.senai.sp.jandira.costurie_app.model

import com.google.gson.annotations.SerializedName

data class TagsResponse(
    @SerializedName("id_tag") val id: Int,
    @SerializedName("nome") val nome_tag: String,
    val imagem: String,
    val id_categoria: Int,
    //val nome_categoria: String,
)
