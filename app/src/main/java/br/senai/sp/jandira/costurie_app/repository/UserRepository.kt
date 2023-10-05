package br.senai.sp.jandira.costurie_app.repository

import android.net.Uri
import br.senai.sp.jandira.costurie_app.model.TagsResponse
import br.senai.sp.jandira.costurie_app.model.UserResponse
import br.senai.sp.jandira.costurie_app.service.RetrofitFactory
import br.senai.sp.jandira.costurie_app.service.UserService
import com.google.gson.JsonArray
import com.google.gson.JsonObject
import retrofit2.Response
import retrofit2.http.Url

class UserRepository {
    private val apiService = RetrofitFactory.getInstance().create(UserService::class.java)

    suspend fun getUser(id: Int, token: String): Response<JsonObject> {
        return apiService.getUser(id, token)
    }

    suspend fun updateUser(
        id: Int,
        token: String,
        id_localizacao: Int,
        cidade: String,
        estado: String,
        bairro: String,
        nome: String,
        descricao: String,
        foto: Uri?,
        nome_de_usuario: String,
        tags: List<TagsResponse>
    ): Response<UserResponse> {
        val requestBody = JsonObject().apply {
            addProperty("id_usuario", id)
            addProperty("id_localizacao", id_localizacao)
            addProperty("cidade", cidade)
            addProperty("estado", estado)
            addProperty("bairro", bairro)
            addProperty("nome", nome)
            addProperty("descricao", descricao)
            if (foto != null) {
                // Converte o Uri em uma String
                addProperty("foto", foto.toString())
            }
            addProperty("nome_de_usuario", nome_de_usuario)
            val tagsArray = JsonArray()
            for (tag in tags) {
                val tagObject = JsonObject().apply {
                    addProperty("id_tag", tag.id_tag)
                    addProperty("nome", tag.nome_tag)
                }
                tagsArray.add(tagObject)
            }
            add("tags", tagsArray)
        }
        return apiService.updateUser(requestBody, token)
    }

    suspend fun updateUserNamePicDesc(
        id: Int,
        nome: String,
        descricao: String,
        foto: String?,
    ): Response<UserResponse> {
        val requestBody = JsonObject().apply {
            addProperty("id", id)
            addProperty("nome", nome)
            addProperty("descricao", descricao)
            if (foto != null) {
                // Converte o Uri em uma String
                addProperty("foto", foto.toString())
            }
        }
        return apiService.updateUserNamePicDesc(requestBody)
    }

    suspend fun updateLocation(
        id: Int,
        token: String,
        cidade: String,
        estado: String,
        bairro: String
    ): Response<UserResponse> {
        val requestBody = JsonObject().apply {
            addProperty("id_usuario", id)
            addProperty("cidade", cidade)
            addProperty("estado", estado)
            addProperty("bairro", bairro)
        }
        return apiService.updateLocation(requestBody, token)
    }

}