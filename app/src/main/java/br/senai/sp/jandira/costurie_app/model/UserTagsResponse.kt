package br.senai.sp.jandira.costurie_app.model

import com.google.gson.annotations.SerializedName

data class UserTagsResponse(
    @SerializedName("id_usuario") var id: Int? = 0,
    @SerializedName("tags") var tags: MutableList<TagResponseId>
)
