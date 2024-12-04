package br.edu.ifsc.aquilombar.data.local.entities

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.ForeignKey.CASCADE
import androidx.room.PrimaryKey

@Entity(
    tableName = "studentAssistance",
    foreignKeys = [
        ForeignKey(
            entity = CampusEntity::class,
            parentColumns = arrayOf("pk"),
            childColumns = arrayOf("campusPk"),
            onDelete = CASCADE,
            onUpdate = CASCADE
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