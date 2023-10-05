package br.senai.sp.jandira.costurie_app.repository

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import br.senai.sp.jandira.costurie_app.R

class CategoryRepository {
    companion object {
        @Composable
        fun getCategories(): List<Category> {
            return listOf<Category>(
                Category(
                    id = 1,
                    name = "Teste",
                    image = ""
                ),
                Category(
                    id = 2,
                    name = "Crochê",
                    image = ""
                ),
                Category(
                    id = 3,
                    name = "Teste2",
                    image = ""
                ),
                Category(
                    id = 4,
                    name = "Teste4",
                    image = ""
                ),
                Category(
                    id = 5,
                    name = "Teste4",
                    image = ""
                ),
                Category(
                    id = 6,
                    name = "Teste4",
                    image = ""
                ),
                Category(
                    id = 7,
                    name = "Teste4",
                    image = ""
                ),
                Category(
                    id = 8,
                    name = "Teste4",
                    image = ""
                ),
            )
        }
    }
}