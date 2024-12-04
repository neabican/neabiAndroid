package br.edu.ifsc.aquilombar.domain.model

data class Address(
    val pk: Int,
    val city: String,
    val state: String,
    val public_place: String,
    val number: String,
    val zip_code: String,
    val latitude: String,
    val longitude: String
)
