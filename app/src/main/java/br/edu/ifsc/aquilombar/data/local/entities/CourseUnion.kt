package br.edu.ifsc.aquilombar.data.local.entities

import androidx.room.Embedded
import androidx.room.Relation


data class CourseUnion(
    @Embedded
    val coursesEntity: CoursesEntity,
    @Relation(
        parentColumn = "coursePk",
        entityColumn = "pk"
    )
    val courseEntity: CourseEntity
)
