package br.edu.ifsc.aquilombar.domain.model

data class Project(
    val pk: Int,
    val name: String,
    val description: String,
    val link: String,
    val campus: Int
)
