package br.edu.ifsc.neabiAndroid.data.source.model

import com.squareup.moshi.Json

class SourceInstitution(
    val pk: Int,

    @Json(name = "nome")
    val name: String,

    @Json(name = "sigla")
    val initials: String
)