package br.senai.sp.jandira.costurie_app.repository

import br.senai.sp.jandira.costurie_app.model.BaseResponse
import br.senai.sp.jandira.costurie_app.model.CityResponse
import br.senai.sp.jandira.costurie_app.model.NeighborhoodResponse
import br.senai.sp.jandira.costurie_app.model.StateResponse
import br.senai.sp.jandira.costurie_app.service.RetrofitFactory
import br.senai.sp.jandira.costurie_app.service.UserService
import com.google.gson.JsonObject
import retrofit2.Response

class LocationRepository {
    private val apiService = RetrofitFactory.getInstance2().create(UserService::class.java)

    private val apiService2 = RetrofitFactory.getInstance().create(UserService::class.java)

    suspend fun getEstados(): Response<List<StateResponse>> {
        return apiService.getStates()
    }

    suspend fun getCidades(UF: String): Response<List<CityResponse>> {
        return apiService.getCitys(UF)
    }

    suspend fun getBairros(ID: Int): Response<List<NeighborhoodResponse>> {
        return apiService.getNeighborhood(ID)
    }

    suspend fun registerLocation(idUsuario: Int, estado: String, cidade: String, bairro: String): Response<JsonObject> {
        val requestBody = JsonObject().apply {
            addProperty("id_usuario", idUsuario)
            addProperty("estado", estado)
            addProperty("cidade", cidade)
            addProperty("bairro", bairro)
        }

        return apiService2.postLocation(requestBody)
    }
}