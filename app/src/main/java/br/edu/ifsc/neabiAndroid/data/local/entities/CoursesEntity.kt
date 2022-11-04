package br.edu.ifsc.neabiAndroid.data.local.entities

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import br.edu.ifsc.neabiAndroid.domain.model.Course
import br.edu.ifsc.neabiAndroid.domain.model.Courses

@Entity(
    tableName = "courses",
    foreignKeys = [
        ForeignKey(
            entity = CourseEntity::class,
            parentColumns = arrayOf("pk"),
            childColumns = arrayOf("coursePk"),
            onDelete = ForeignKey.CASCADE,
            onUpdate = ForeignKey.CASCADE
        ),
        ForeignKey(
            entity = CampusEntity::class,
            parentColumns = arrayOf("pk"),
            childColumns = arrayOf("campusPk"),
            onDelete = ForeignKey.CASCADE,
            onUpdate = ForeignKey.CASCADE
        )
    ]
)
data class CoursesEntity(
    @PrimaryKey
    val pk: Int,
    val link: String,
    val addition_info: String,
    val vacancies: Int,
    val coursePk: Int,
    val campusPk: Int
)

