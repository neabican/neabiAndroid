package br.edu.ifsc.aquilombar.data.remote.dto

import br.edu.ifsc.aquilombar.data.local.entities.StudentAssistanceEntity
import com.squareup.moshi.Json

data class StudentAssistanceDto(
    val pk: Int,

    @Json(name = "nome")
    val name: String,

    @Json(name = "descricao")
    val description: String,

    val link: String = "",
    val campus: Int
){
    fun toEntity(): StudentAssistanceEntity{
        return StudentAssistanceEntity(
            pk = pk,
            name = name,
            description = description,
            link = link,
            campusPk = campus
        )
    }
}
