package br.senai.sp.jandira.costurie_app.viewModel

import androidx.lifecycle.ViewModel
import br.senai.sp.jandira.costurie_app.model.TagsResponse

class TagsViewModel: ViewModel() {
    var tags: MutableList<TagsResponse>? = mutableListOf()
}