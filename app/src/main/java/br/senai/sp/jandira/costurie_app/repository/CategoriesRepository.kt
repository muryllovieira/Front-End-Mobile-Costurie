package br.senai.sp.jandira.costurie_app.repository

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import br.senai.sp.jandira.costurie_app.R
import br.senai.sp.jandira.costurie_app.model.Filtering
import br.senai.sp.jandira.costurie_app.model.StateResponse
import br.senai.sp.jandira.costurie_app.service.CategoriesService
import br.senai.sp.jandira.costurie_app.service.RetrofitFactory
import br.senai.sp.jandira.costurie_app.service.UserService
import com.google.gson.JsonObject
import retrofit2.Response

class FilteringRepository {
    private val apiService = RetrofitFactory.getInstance().create(CategoriesService::class.java)

    suspend fun getCategories(token: String): Response<JsonObject> {
        return apiService.getCategory(token)

    }
}