package br.edu.ifsc.aquilombar.domain.model

data class Program(
    val pk: Int,
    val name: String,
    val description: String,
    val link: String,
    val campus: Int
)
