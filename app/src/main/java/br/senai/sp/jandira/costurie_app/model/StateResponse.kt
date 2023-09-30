package br.senai.sp.jandira.costurie_app.model

data class StateResponse(
    val id: Int,
    val sigla: String,
    val nome: String
): Comparable<StateResponse> {
    override fun compareTo(other: StateResponse): Int {
        return sigla.compareTo(other.sigla)
    }
}
