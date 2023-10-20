package br.senai.sp.jandira.costurie_app.model

import com.google.gson.annotations.SerializedName

data class BaseResponseTag(
    @SerializedName("tags")
    var data: List<TagsResponse>
)
