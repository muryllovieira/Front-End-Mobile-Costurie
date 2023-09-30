package br.senai.sp.jandira.costurie_app.viewModel

import androidx.lifecycle.ViewModel
import br.senai.sp.jandira.costurie_app.model.TagsResponse

class UserViewModel: ViewModel(){
    var id_usuario: Int? = 0
    var nome: String = ""
    var descricao: String = ""
    var nome_de_usuario: String = ""
    var email: String = ""
    var foto: String = ""
    var id_localizacao: Int? = 0
    var cidade: String = ""
    var estado: String = ""
    var bairro: String = ""
    var tags: MutableList<TagsResponse> = mutableListOf()
}



