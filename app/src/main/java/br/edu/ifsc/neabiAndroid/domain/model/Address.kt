package br.edu.ifsc.neabiAndroid.domain.model

import br.edu.ifsc.neabiAndroid.data.local.entities.AddressEntity

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
