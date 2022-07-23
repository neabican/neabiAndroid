package br.edu.ifsc.neabiAndroid.data.remote.dto

import br.edu.ifsc.neabiAndroid.domain.model.Course
import com.squareup.moshi.Json

data class CourseDto(
    val pk: Int,

    @Json(name = "nome")
    val name: String,

    @Json(name = "descricao")
    val description: String
){
    fun toDomain(): Course{
        return Course(
            pk = pk,
            name = name,
            description = description
        )
    }
}
