package br.edu.ifsc.neabiAndroid.data.remote.dto

import br.edu.ifsc.neabiAndroid.data.local.entities.CourseEntity
import br.edu.ifsc.neabiAndroid.domain.model.Course
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
