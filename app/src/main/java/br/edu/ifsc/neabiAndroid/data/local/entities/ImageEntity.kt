package br.edu.ifsc.neabiAndroid.data.local.entities

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(
    tableName = "image",
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

data class ImageEntity(
    @PrimaryKey
    val pk: Int,
    val photo: String,
    val campusPk: Int
)