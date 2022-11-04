package br.edu.ifsc.neabiAndroid.data.remote.dto

import br.edu.ifsc.neabiAndroid.domain.model.DBVersion
import com.squareup.moshi.Json

data class DBVersionDto(
    val pk: Int,

    @Json(name = "versao")
    val version: Int
)