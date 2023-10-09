package br.senai.sp.jandira.costurie_app.testes

import android.annotation.SuppressLint
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import br.senai.sp.jandira.costurie_app.R

class ProfileRepository {
    companion object {
        @SuppressLint("ResourceType")
        @Composable
        fun getProfiles(): List<Profile> {
            return listOf<Profile>(
                Profile(
                    id = 1,
                    name = "Beltraninha Santos",
                    image = stringResource(id = R.drawable.profile_pic)
                ),
                Profile(
                    id = 2,
                    name = "Cyclana da Silva",
                    image = stringResource(id = R.drawable.profile_pic)
                ),
                Profile(
                    id = 3,
                    name = "Jorgina Souza",
                    image = stringResource(id = R.drawable.profile_pic)
                ),
                Profile(
                    id = 4,
                    name = "Gertrudes Santos Souza",
                    image = stringResource(id = R.drawable.profile_pic)
                )
            )
        }
    }
}