package br.edu.ifsc.neabiAndroid.data.source.model

import com.squareup.moshi.Json

data class SourceCourses(
    val pk: Int,
    val link: String,

    @Json(name = "curso")
    val sourceCourse: SourceCourse
)