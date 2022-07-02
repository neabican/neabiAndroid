package br.edu.ifsc.neabiAndroid.source.model

import com.squareup.moshi.Json

data class SourceAddress(

    @Json(name="cidade")
    val city: String,

    @Json(name = "estado")
    val state: String,

    @Json(name = "logradouro")
    val public_place: String,

    @Json(name = "numero")
    val number: String,

    @Json(name = "cep")
    val zip_code: String,

    //String? Será necessario fazer o calculo de distancia?
    val latitude: String,
    val longitude: String
)
