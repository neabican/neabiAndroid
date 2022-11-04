package br.edu.ifsc.neabiAndroid.domain.model

data class Courses(
    val pk: Int,
    val link: String,
    val addition_info: String,
    val vacancies: Int,
    val course: Course,
    val campus: Int
)