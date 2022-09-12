package br.edu.ifsc.neabiAndroid.data.local.entities

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.ForeignKey.CASCADE
import androidx.room.ForeignKey.RESTRICT
import androidx.room.PrimaryKey
import br.edu.ifsc.neabiAndroid.domain.model.Program
import br.edu.ifsc.neabiAndroid.domain.model.Project

@Entity(
    tableName = "project",
    foreignKeys = [
        ForeignKey(
            entity = CampusEntity::class,
            parentColumns = arrayOf("pk"),
            childColumns = arrayOf("campusPk"),
            onUpdate = CASCADE,
            onDelete = CASCADE
        )
    ]
)
data class ProjectEntity(
    @PrimaryKey
    val pk: Int,
    val name: String,
    val description: String,
    val link: String,
    val campusPk: Int
)

fun List<ProjectEntity>.toDomain(): List<Project>{
    return map{
        Project(
            pk = it.pk,
            name = it.name,
            description = it.description,
            link = it.link,
            campus = it.campusPk
        )
    }
}
