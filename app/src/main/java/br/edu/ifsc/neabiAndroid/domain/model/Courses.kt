package br.edu.ifsc.neabiAndroid.domain.model

import br.edu.ifsc.neabiAndroid.data.local.entities.CoursesEntity

data class Courses(
    val pk: Int,
    val link: String,
    val course: Course,
    val campus: Int
)