package br.senai.sp.jandira.costurie_app.repository

import br.senai.sp.jandira.costurie_app.service.RetrofitFactory
import br.senai.sp.jandira.costurie_app.service.UserService
import com.google.gson.JsonObject
import retrofit2.Response

class PasswordResetRepository {

    private val apiService = RetrofitFactory.getInstance().create(UserService::class.java)

    suspend fun requestPasswordReset(email: String): Response<JsonObject> {
        val requestBody = JsonObject().apply {
            addProperty("email", email)
        }

        return apiService.requestPasswordReset(requestBody)
    }

    suspend fun validateResetCode(id: Int, token: String): Response<JsonObject> {
        val requestBody = JsonObject().apply {
            addProperty("id", id)
            addProperty("token", token)
        }

        return apiService.tokenValidation(requestBody)
    }

    suspend fun updatePassword(id: Int, senha: String): Response<JsonObject> {
        val requestBody = JsonObject().apply {
            addProperty("id", id)
            addProperty("senha", senha)
        }


        return apiService.updateUserPassword(requestBody)

    }

}