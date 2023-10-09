package br.senai.sp.jandira.costurie_app.repository

import androidx.compose.runtime.Composable
import br.senai.sp.jandira.costurie_app.model.CategoryResponse

class CategoryRepository {
    companion object {
        @Composable
        fun getCategories(): List<CategoryResponse> {
            return listOf<CategoryResponse>(
                CategoryResponse(
                    id = 1,
                    name = "Teste"
                ),
                CategoryResponse(
                    id = 2,
                    name = "Crochê"
                ),
                CategoryResponse(
                    id = 3,
                    name = "Teste2"
                ),
                CategoryResponse(
                    id = 4,
                    name = "Teste4"
                )
            )
        }
    }
}