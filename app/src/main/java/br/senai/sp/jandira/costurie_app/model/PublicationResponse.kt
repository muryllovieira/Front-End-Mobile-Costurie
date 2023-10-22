package br.senai.sp.jandira.costurie_app.model

import com.google.gson.annotations.SerializedName

data class PublicationResponse(
    @SerializedName("id_usuario") var id_usuario: Int = 0,
    @SerializedName("titulo") var titulo: String = "",
    @SerializedName("descricao") var descricao: String = "",
    @SerializedName("tags") var tags: List<TagsResponse> = mutableListOf(),
    @SerializedName("anexos") var anexos: List<AnexoResponse> = mutableListOf()
)
