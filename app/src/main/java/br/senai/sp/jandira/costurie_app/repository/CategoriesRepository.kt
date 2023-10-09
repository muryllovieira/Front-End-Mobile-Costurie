package br.senai.sp.jandira.costurie_app.repository

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import br.senai.sp.jandira.costurie_app.R
import br.senai.sp.jandira.costurie_app.model.Filtering

class CategoriesRepository {
    companion object {
        @Composable
        fun getFiltering(): List<Filtering> {
            return listOf<Filtering>(
                Filtering(
                    id = 1,
                    name = stringResource(id = R.string.text_filtragem_geral)
                ),
                Filtering(
                    id = 2,
                    name = stringResource(id = R.string.text_filtragem_vestuario)
                ),
                Filtering(
                    id = 3,
                    name = stringResource(id = R.string.text_filtragem_decoracao)
                ),
                Filtering(
                    id = 4,
                    name = stringResource(id = R.string.text_filtragem_acessorios)
                ),
                Filtering(
                    id = 5,
                    name = stringResource(id = R.string.text_filtragem_ajustes)
                ),
                Filtering(
                    id = 6,
                    name = stringResource(id = R.string.text_filtragem_pet)
                )
            )
        }
    }
}