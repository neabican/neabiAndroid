package br.edu.ifsc.neabiAndroid.data.local.entities

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(
    tableName = "program",
    foreignKeys = [
        ForeignKey(
            entity = CampusEntity::class,
            parentColumns = arrayOf("pk"),
            childColumns = arrayOf("campusPk"),
            onUpdate = ForeignKey.CASCADE,
            onDelete = ForeignKey.CASCADE
        )
    ]
)
data class ProgramEntity(
    @PrimaryKey
    val pk: Int,
    val name: String,
    val description: String,
    val link: String,
    val campusPk: Int
)
