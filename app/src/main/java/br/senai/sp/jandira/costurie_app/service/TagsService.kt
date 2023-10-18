package br.senai.sp.jandira.costurie_app.service

import br.senai.sp.jandira.costurie_app.model.BaseResponseTag
import br.senai.sp.jandira.costurie_app.model.BaseResponseTag2
import br.senai.sp.jandira.costurie_app.model.UserResponse
import com.google.gson.JsonObject
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Headers
import retrofit2.http.POST

interface TagsService {

    @Headers("Content-Type: application/json")
    @POST("/tag/tag_by_categoria")
    suspend fun getTags(
        @Body requestBody: JsonObject,
        @Header("x-access-token") token: String
    ): Response<JsonObject>

    @Headers("Content-Type: application/json")
    @GET("/tag")
    suspend fun getAllTags(
        @Header("x-access-token") token: String
    ): Response<BaseResponseTag>

    @Headers("Content-Type: application/json")
    @POST("/usuario/select_by_tag")
    suspend fun getUserByTag(
        @Body requestBody: JsonObject,
        @Header("x-access-token") token: String
    ): Response<JsonObject>

    @Headers("Content-Type: application/json")
    @GET("/tag")
    suspend fun getAllTags2(
        @Header("x-access-token") token: String
    ): Response<BaseResponseTag2>
}