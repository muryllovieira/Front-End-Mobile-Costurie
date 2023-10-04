package br.senai.sp.jandira.costurie_app.repository

import android.media.Image

data class Category (
    var id: Long = 0,
    var name: String = "",
    var image: Image? = null
){
}