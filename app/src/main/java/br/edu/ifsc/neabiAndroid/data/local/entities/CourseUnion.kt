package br.edu.ifsc.neabiAndroid.data.local.entities

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.Relation
import br.edu.ifsc.neabiAndroid.domain.model.Courses
import br.edu.ifsc.neabiAndroid.util.toDomain


data class CourseUnion(
    @Embedded
    val coursesEntity: CoursesEntity,
    @Relation(
        parentColumn = "coursePk",
        entityColumn = "pk"
    )
    val courseEntity: CourseEntity
)
