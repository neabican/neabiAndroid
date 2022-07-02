package br.edu.ifsc.neabiAndroid.source.model

import com.squareup.moshi.Json

data class SourceCourses(
    val pk: Int,
    val link: String,

    @Json(name = "curso")
    val sourceCourse: SourceCourse
)