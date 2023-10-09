package br.senai.sp.jandira.costurie_app.function

import android.content.Context
import br.senai.sp.jandira.costurie_app.models_private.User
import br.senai.sp.jandira.costurie_app.sqlite_repository.UserRepositorySqlite

fun saveLogin (
    context: Context,
    id: Long,
    nome: String,
    token: String,
    email: String,
    senha: String,
): Long {
    val newUser = User(
        id = id,
        nome = nome,
        token = token,
        email = email,
        senha = senha,
    )

    return UserRepositorySqlite(context).save(newUser)
}

fun deleteUserSQLite(context: Context): Int {
    return UserRepositorySqlite(context).deleteUser()
}