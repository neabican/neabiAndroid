package br.edu.ifsc.aquilombar.data.local.entities

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.ForeignKey.CASCADE
import androidx.room.PrimaryKey

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
