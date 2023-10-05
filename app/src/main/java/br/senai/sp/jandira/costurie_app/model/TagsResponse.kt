package br.senai.sp.jandira.costurie_app.model

import com.google.gson.annotations.SerializedName

data class TagsResponse(
    val id_tag: Int,
    @SerializedName("nome") val nome_tag: String,
    val imagem_tag: String,
    val id_categoria: Int,
    val nome_categoria: String,
)
