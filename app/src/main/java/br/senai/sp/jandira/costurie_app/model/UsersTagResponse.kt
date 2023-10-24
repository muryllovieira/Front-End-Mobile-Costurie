package br.senai.sp.jandira.costurie_app.model

import com.google.gson.annotations.SerializedName

data class UsersTagResponse(
    @SerializedName("id_usuario") val id: Int,
    @SerializedName("nome") val nome: String,
    @SerializedName("descricao") val descricao: String,
    @SerializedName("foto") val foto: String,
    @SerializedName("nome_de_usuario") val nome_de_usuario: String,
    @SerializedName("email") val email: String,
    @SerializedName("senha") val senha: String,
    @SerializedName("id_localizacao") val id_localizacao: String,
    @SerializedName("cidade") val cidade: String,
    @SerializedName("bairro") val bairro: String,
    @SerializedName("estado") val estado: String
)
