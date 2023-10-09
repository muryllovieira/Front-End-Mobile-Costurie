package br.senai.sp.jandira.costurie_app.service

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

object RetrofitFactory {


    private const val BASE_URL = "http://10.107.144.10:3000"

    //IP DO MURYLLO, NÃO TIRA SÓ COMENTAAA
<<<<<<< HEAD
    //private const val BASE_URL = "http://192.168.3.7:3000"
=======
    private const val BASE_URL = "http://10.107.144.10:3000"
>>>>>>> e630ad8e14114dcce58e14ce058c02166db2c3ec

    fun getInstance(): Retrofit{
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }


    private const val URL_IBGE = "https://servicodados.ibge.gov.br/api/v1/localidades/"

    fun getInstance2(): Retrofit{
        return Retrofit.Builder()
            .baseUrl(URL_IBGE)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

}