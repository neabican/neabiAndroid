package br.edu.ifsc.neabiAndroid.data.local.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import br.edu.ifsc.neabiAndroid.domain.model.Course

@Entity(tableName = "course")
data class CourseEntity (
    @PrimaryKey
    val pk: Int,
    val name: String,
    val description: String,
)


fun CourseEntity.toDomain(): Course {
    return Course(
        pk = this.pk,
        name = this.name,
        description = this.description
    )
}