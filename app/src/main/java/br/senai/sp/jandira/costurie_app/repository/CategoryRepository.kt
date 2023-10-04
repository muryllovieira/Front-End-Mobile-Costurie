package br.senai.sp.jandira.costurie_app.repository

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource

class CategoryRepository {
    companion object {
        @Composable
        fun getCategories(): List<Category> {
            return listOf<Category>(
                Category(
                    id = 1,
                    name = "Teste",
                    image = null
                ),
                Category(
                    id = 2,
                    name = "Crochê",
                    image = null
                ),
                Category(
                    id = 3,
                    name = "Teste2",
                    image = null
                ),
                Category(
                    id = 4,
                    name = "Teste4",
                    image = null
                ),
            )
        }
    }
}