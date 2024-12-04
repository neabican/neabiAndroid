package br.edu.ifsc.aquilombar.domain.model

data class Institution(
    val pk: Int,
    val name: String,
    val initials: String,
    val campus: List<Campus>
)