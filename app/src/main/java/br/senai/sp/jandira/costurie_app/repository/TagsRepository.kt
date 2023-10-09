package br.senai.sp.jandira.costurie_app.repository

import br.senai.sp.jandira.costurie_app.model.CategoryAndTags
import br.senai.sp.jandira.costurie_app.model.TagsResponse
import br.senai.sp.jandira.costurie_app.service.RetrofitFactory
import br.senai.sp.jandira.costurie_app.service.TagsService
import br.senai.sp.jandira.costurie_app.service.UserService
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

    suspend fun getAllTags(token: String): Response<CategoryAndTags> {

        return apiService.getAllTags(token)

    }
}