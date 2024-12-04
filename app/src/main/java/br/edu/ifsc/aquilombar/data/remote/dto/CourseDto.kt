package br.edu.ifsc.aquilombar.data.remote.dto

import br.edu.ifsc.aquilombar.data.local.entities.CourseEntity
import com.squareup.moshi.Json

data class CourseDto(
    val pk: Int,

    @Json(name = "nome")
    val name: String,

    @Json(name = "descricao")
    val description: String
){
    fun toEntity(): CourseEntity{
        return CourseEntity(
            pk = pk,
            name = name,
            description = description
        )
    }
}
