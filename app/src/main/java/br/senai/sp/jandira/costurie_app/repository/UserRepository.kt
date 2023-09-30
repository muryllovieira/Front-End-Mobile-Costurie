package br.senai.sp.jandira.costurie_app.repository

import android.util.Log
import br.senai.sp.jandira.costurie_app.model.BaseResponse
import br.senai.sp.jandira.costurie_app.model.StateResponse
import br.senai.sp.jandira.costurie_app.model.UserJsonResponse
import br.senai.sp.jandira.costurie_app.model.UserResponse
import br.senai.sp.jandira.costurie_app.service.RetrofitFactory
import br.senai.sp.jandira.costurie_app.service.UserService
import com.google.gson.JsonObject
import retrofit2.Response

class UserRepository {
    private val apiService = RetrofitFactory.getInstance().create(UserService::class.java)

    suspend fun getUser(id: Int, token: String): Response<JsonObject> {
        return apiService.getUser(id, token)
    }
    suspend fun updateUser(id: Int, token: String): Response<JsonObject> {
        val requestBody = JsonObject().apply {
            addProperty("id", id)
            //addProperty("token", token)
        }

        return apiService.updateUser(requestBody, token)

    }
}