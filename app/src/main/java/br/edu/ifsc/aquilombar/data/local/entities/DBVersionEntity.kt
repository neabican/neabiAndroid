package br.edu.ifsc.aquilombar.data.local.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "db_version")
data class DBVersionEntity(
    @PrimaryKey
    val pk: Int,
    val version: Int
)