package br.edu.ifsc.neabiAndroid.data.local.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "institution")
data class InstitutionEntity(
    @PrimaryKey
    val pk: Int,
    val name: String,
    val initials: String
)
