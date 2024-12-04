package br.edu.ifsc.aquilombar.data.remote.dto

import com.squareup.moshi.Json

data class DBVersionDto(
    val pk: Int,

    @Json(name = "versao")
    val version: Int
)