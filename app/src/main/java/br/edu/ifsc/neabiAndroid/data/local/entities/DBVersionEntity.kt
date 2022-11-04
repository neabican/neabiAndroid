package br.edu.ifsc.neabiAndroid.data.local.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import br.edu.ifsc.neabiAndroid.domain.model.DBVersion

@Entity(tableName = "db_version")
data class DBVersionEntity(
    @PrimaryKey
    val pk: Int,
    val version: Int
)