package br.edu.ifsc.aquilombar.data.local.entities

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(
    tableName = "campus",
    foreignKeys = [
        ForeignKey(
            entity = AddressEntity::class,
            parentColumns = arrayOf("pk"),
            childColumns = arrayOf("addressPk"),
            onDelete = ForeignKey.CASCADE,
            onUpdate = ForeignKey.CASCADE
        ),
        ForeignKey(
            entity = InstitutionEntity::class,
            parentColumns = arrayOf("pk"),
            childColumns = arrayOf("institutionPk"),
            onDelete = ForeignKey.CASCADE,
            onUpdate = ForeignKey.CASCADE
        )
    ]
    )
data class CampusEntity(
    @PrimaryKey
    val pk: Int,
    val name: String,
    val link: String,
    val institutionPk: Int,
    val addressPk: Int,
    val description: String,
)
