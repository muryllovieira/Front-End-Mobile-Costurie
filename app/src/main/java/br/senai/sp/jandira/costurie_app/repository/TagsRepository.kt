package br.senai.sp.jandira.costurie_app.repository

import br.senai.sp.jandira.costurie_app.model.BaseResponseTag
import br.senai.sp.jandira.costurie_app.service.RetrofitFactory
import br.senai.sp.jandira.costurie_app.service.TagsService
import com.google.gson.JsonObject
import retrofit2.Response

class TagsRepository {
    private val apiService = RetrofitFactory.getInstance().create(TagsService::class.java)

    suspend fun getTags(token: String, categoria: String): Response<JsonObject> {
        val requestBody = JsonObject().apply {
            addProperty("categoria", categoria)

        }

        return apiService.getTags(requestBody, token)
    }

    suspend fun getAllTags(token: String): Response<BaseResponseTag> {

        return apiService.getAllTags(token)

    }
}