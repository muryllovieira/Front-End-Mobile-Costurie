package br.senai.sp.jandira.costurie_app.service

import com.google.gson.JsonObject
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST

interface UserService {

    //https://super-hare-shoulder-pads.cyclic.cloud/

    @Headers("Content-Type: application/json")
    @POST("/usuario/cadastro")
    suspend fun createUser(@Body body: JsonObject): Response<JsonObject>
}