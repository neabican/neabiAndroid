package br.edu.ifsc.neabiAndroid.source.model

import com.squareup.moshi.Json

data class SourceProject(
    val pk: Int,

    @Json(name = "nome")
    val name: String,

    @Json(name = "descricao")
    val description: String,

    val link: String,
    val campus: Int
)
