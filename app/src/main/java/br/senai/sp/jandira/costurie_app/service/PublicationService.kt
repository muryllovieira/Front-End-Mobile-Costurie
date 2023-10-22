package br.senai.sp.jandira.costurie_app.service

import br.senai.sp.jandira.costurie_app.model.PublicationResponse
import br.senai.sp.jandira.costurie_app.model.UserResponse
import com.google.gson.JsonObject
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.Header
import retrofit2.http.Headers
import retrofit2.http.POST

interface PublicationService {

    @Headers("Content-Type: application/json")
    @POST("/publicacao/inserir")
    suspend fun createPublication(
        @Body body: JsonObject,
        @Header("x-access-token") token: String
    ): Response<PublicationResponse>

}