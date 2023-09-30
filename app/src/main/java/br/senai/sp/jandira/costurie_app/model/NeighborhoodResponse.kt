package br.senai.sp.jandira.costurie_app.model

data class NeighborhoodResponse(
    val id: Int,
    val nome: String
): Comparable<NeighborhoodResponse> {
    override fun compareTo(other: NeighborhoodResponse): Int {
        return nome.compareTo(other.nome)
    }
}