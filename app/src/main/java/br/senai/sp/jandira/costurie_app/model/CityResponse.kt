package br.senai.sp.jandira.costurie_app.model

data class CityResponse(
    val id: Int,
    val nome: String
): Comparable<CityResponse> {
    override fun compareTo(other: CityResponse): Int {
        return nome.compareTo(other.nome)
    }
}
