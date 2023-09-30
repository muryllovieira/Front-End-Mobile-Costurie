package br.senai.sp.jandira.costurie_app.model

data class UserJsonResponse(
    val status: Int,
    val usuario: UserResponse,
    val message: String
)
