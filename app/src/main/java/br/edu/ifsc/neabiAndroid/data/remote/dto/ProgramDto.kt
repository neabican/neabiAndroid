package br.edu.ifsc.neabiAndroid.data.remote.dto

import br.edu.ifsc.neabiAndroid.domain.model.Program
import com.squareup.moshi.Json

data class ProgramDto(
    val pk: Int,

    @Json(name = "nome")
    val name: String,

    @Json(name = "descricao")
    val description: String,

    val link: String = "",
    val campus: Int
){
    fun toDomain(): Program{
        return Program(
            pk = pk,
            name = name,
            description = description,
            link = link,
            campus = campus
        )
    }
}
