package br.edu.ifsc.aquilombar.data.local.entities

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

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

