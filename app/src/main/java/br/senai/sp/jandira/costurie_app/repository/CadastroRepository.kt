package br.senai.sp.jandira.costurie_app.repository

import br.senai.sp.jandira.costurie_app.service.RetrofitFactory
import br.senai.sp.jandira.costurie_app.service.UserService
import com.google.gson.JsonObject
import retrofit2.Response

class CadastroRepository {
    private val apiService = RetrofitFactory.getInstance().create(UserService::class.java)

    suspend fun registerUser(nomeDeUsuario: String, email: String, senha: String): Response<JsonObject> {
        val requestBody = JsonObject().apply {
            addProperty("nome_de_usuario", nomeDeUsuario)
            addProperty("email", email)
            addProperty("senha", senha)
        }

        return apiService.createUser(requestBody)
    }
}