package br.edu.ifsc.neabiAndroid.data.remote.dto

import br.edu.ifsc.neabiAndroid.data.local.entities.StudentAssistanceEntity
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
