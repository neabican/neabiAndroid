package br.edu.ifsc.neabiAndroid.data.remote.dto

import br.edu.ifsc.neabiAndroid.data.local.entities.CoursesEntity
import br.edu.ifsc.neabiAndroid.domain.model.Courses
import com.squareup.moshi.Json

data class CoursesDto(
    val pk: Int,
    val link: String,
    @Json(name = "curso")
    val courseDto: CourseDto
)

fun List<CoursesDto>.toEntity(campusPk: Int): List<CoursesEntity>{
    return map{
        CoursesEntity(
            pk = it.pk,
            link = it.link,
            coursePk = it.courseDto.pk,
            campusPk = campusPk
        )
    }
}