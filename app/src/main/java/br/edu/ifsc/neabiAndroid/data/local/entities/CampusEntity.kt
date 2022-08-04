package br.edu.ifsc.neabiAndroid.data.local.entities

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
            onDelete = ForeignKey.RESTRICT,
            onUpdate = ForeignKey.CASCADE
        ),
        ForeignKey(
            entity = InstitutionEntity::class,
            parentColumns = arrayOf("pk"),
            childColumns = arrayOf("institutionPk"),
            onDelete = ForeignKey.RESTRICT,
            onUpdate = ForeignKey.CASCADE
        )
    ]
    )
data class CampusEntity(
    @PrimaryKey
    val pk: Int,
    val name: String,
    val image: String,
    val institutionPk: Int,
    val addressPk: Int,
)
