package br.edu.ifsc.neabiAndroid.domain.model

data class AffirmativeAction(
    val pk: Int,
    val name: String,
    val description: String,
    val link: String,
    val campus: Int
)
