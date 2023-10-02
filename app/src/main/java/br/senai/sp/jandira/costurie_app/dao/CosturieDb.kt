package br.senai.sp.jandira.costurie_app.dao

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import br.senai.sp.jandira.costurie_app.models_private.User

@Database(entities = [User::class], version = 1)
abstract class CosturieDb : RoomDatabase() {

    abstract fun userDao() : UserDao

    companion object {

        private lateinit var instanceDb: CosturieDb

        fun getDatabase(context: Context): CosturieDb {
            // :: =  entregar uma instancia do objeto, me devolve um false se não existir nada

            //se isso for verdade
            if (!::instanceDb.isInitialized) {
                //.databaseBuilder =  criar um banco de dados
                // criar a instancia
                instanceDb = Room
                    .databaseBuilder(
                        context, //contexto da minha aplicação
                        CosturieDb::class.java, //ja esta criando automaticamente a instancia
                        "db_costurie" // nome do banco
                    ).allowMainThreadQueries().build()
            }
            return instanceDb

        }
    }
}