package br.senai.sp.jandira.costurie_app.model

import com.google.gson.annotations.SerializedName

data class TagsResponse(
    @SerializedName("id_tag") val id: Int,
    @SerializedName("nome") val nome_tag: String,
    @SerializedName("imagem") val imagem: String,
    @SerializedName("id_categoria") val id_categoria: Int,
    //@SerializedName("nome_categoria") val nome_categoria: String,
)
