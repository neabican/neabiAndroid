package br.edu.ifsc.neabiAndroid.data.source.model

import com.squareup.moshi.Json

data class SourceCourse(
    @Json(name = "nome")
    val name: String,

    @Json(name = "descricao")
    val description: String
)
