package br.edu.ifsc.neabiAndroid.data.domain

data class AffirmativeAction(
    val pk: Int,
    val name: String,
    val description: String,
    val link: String,
    val campus: Int
)
