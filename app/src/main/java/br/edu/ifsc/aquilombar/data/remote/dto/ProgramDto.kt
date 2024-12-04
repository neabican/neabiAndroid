package br.edu.ifsc.aquilombar.data.remote.dto

import com.squareup.moshi.Json

data class ProgramDto(
    val pk: Int,

    @Json(name = "nome")
    val name: String,

    @Json(name = "descricao")
    val description: String,

    val link: String = "",
    val campus: Int
)

