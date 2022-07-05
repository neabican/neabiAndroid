package br.edu.ifsc.neabiAndroid.data.domain

data class Program(
    val pk: Int,
    val name: String,
    val description: String,
    val link: String,
    val campus: Int
)
