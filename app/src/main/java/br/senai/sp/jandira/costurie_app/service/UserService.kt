package br.senai.sp.jandira.costurie_app.service

import br.senai.sp.jandira.costurie_app.model.BaseResponse
import br.senai.sp.jandira.costurie_app.model.CityResponse
import br.senai.sp.jandira.costurie_app.model.NeighborhoodResponse
import br.senai.sp.jandira.costurie_app.model.StateResponse
import com.google.gson.JsonObject
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path

interface UserService {

    //https://super-hare-shoulder-pads.cyclic.cloud/

    @Headers("Content-Type: application/json")
    @POST("/usuario/cadastro")
    suspend fun createUser(@Body body: JsonObject): Response<JsonObject>

    @Headers("Content-Type: application/json")
    @POST("/usuario/login")
    suspend fun postUser(@Body body: JsonObject): Response<JsonObject>

    @Headers("Content-Type: application/json")
    @POST("/usuario/esqueceu_a_senha")
    suspend fun requestPasswordReset(@Body requestBody: JsonObject): Response<JsonObject>

    @Headers("Content-Type: application/json")
    @POST("/usuario/validar_token")
    suspend fun tokenValidation(@Body requestBody: JsonObject): Response<JsonObject>

    @Headers("Content-Type: application/json")
    @PUT("/usuario/atualizar_senha")
    suspend fun updateUserPassword(@Body body: JsonObject): Response<JsonObject>

    @Headers("Content-Type: application/json")
    @GET("estados")
    suspend fun getStates(): Response<List<StateResponse>>

    @Headers("Content-Type: application/json")
    @GET("estados/{UF}/municipios")
    suspend fun getCitys(@Path("UF") UF: String): Response<List<CityResponse>>

    @Headers("Content-Type: application/json")
    @GET("municipios/{ID}/distritos")
    suspend fun getNeighborhood(@Path("ID") ID: Int): Response<List<NeighborhoodResponse>>
}