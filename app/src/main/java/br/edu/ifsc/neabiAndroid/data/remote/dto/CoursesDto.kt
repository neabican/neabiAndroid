package br.edu.ifsc.neabiAndroid.data.remote.dto

import br.edu.ifsc.neabiAndroid.domain.model.Courses
import com.squareup.moshi.Json

data class CoursesDto(
    val pk: Int,
    val link: String,

    @Json(name = "curso")
    val courseDto: CourseDto
){
    fun toDomain(): Courses{
        return Courses(
            pk = pk,
            link = link,
            course = courseDto.toDomain()
        )
    }
}