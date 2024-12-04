package br.edu.ifsc.aquilombar.data.remote.dto

import com.squareup.moshi.Json

data class CoursesDto(
    val pk: Int,
    val link: String,

    @Json(name = "descricao")
    val addition_info: String,

    @Json(name = "vagas")
    val vacancies: Int,

    @Json(name = "curso")
    val courseDto: CourseDto
)
