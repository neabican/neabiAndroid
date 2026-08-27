package br.edu.ifsc.aquilombar.data.local.entities

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(
    tableName = "studentAssistance",
    foreignKeys = [
        ForeignKey(
            entity = CampusEntity::class,
            parentColumns = arrayOf("pk"),
            childColumns = arrayOf("campusPk"),
            onDelete = ForeignKey.CASCADE,
            onUpdate = ForeignKey.CASCADE
        )
    ]
)
data class StudentAssistanceEntity(
    @PrimaryKey
    val pk: Int,
    val name: String,
    val description: String,
    val link: String,
    val campusPk: Int
)