package br.senai.sp.jandira.costurie_app.service

import com.google.gson.JsonObject
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Path

interface CategoriesService {

    @GET("/categoria/select_all")
    suspend fun getCategory(
        @Header("x-access-token") token: String
    ): Response<JsonObject>

}