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
                    name = "Teste"
                ),
                Category(
                    id = 2,
                    name = "Crochê"
                ),
                Category(
                    id = 3,
                    name = "Teste2"
                ),
                Category(
                    id = 4,
                    name = "Teste4"
                )
            )
        }
    }
}