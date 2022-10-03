package br.edu.ifsc.neabiAndroid.data.local.entities

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.Relation
import br.edu.ifsc.neabiAndroid.domain.model.Courses


data class CourseUnion(
    @Embedded
    val coursesEntity: CoursesEntity,
    @Relation(
        parentColumn = "coursePk",
        entityColumn = "pk"
    )
    val courseEntity: CourseEntity
)

fun List<CourseUnion>.toDomain(): List<Courses>{
    return map{
        Courses(
            pk = it.coursesEntity.pk,
            link = it.coursesEntity.link,
            addition_info = it.coursesEntity.addition_info,
            course = it.courseEntity.toDomain(),
            campus = it.coursesEntity.campusPk
        )
    }
}
