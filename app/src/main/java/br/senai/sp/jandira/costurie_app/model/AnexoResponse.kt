package br.senai.sp.jandira.costurie_app.model

import com.google.gson.annotations.SerializedName

data class AnexoResponse(
    @SerializedName("conteudo") var conteudo: String = "",
)
