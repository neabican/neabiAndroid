package br.edu.ifsc.neabiAndroid.data.domain

data class Address(
    val city: String,
    val state: String,
    val public_place: String,
    val number: String,
    val zip_code: String,
    //String? Será necessario fazer o calculo de distancia?
    val latitude: String,
    val longitude: String
)
