package br.edu.ifsc.neabiAndroid.data.source.model

import com.squareup.moshi.Json

data class SourceProgram(
    val pk: Int,

    @Json(name = "nome")
    val name: String,

    @Json(name = "descricao")
    val description: String,

    val link: String = "",
    val campus: Int
)
