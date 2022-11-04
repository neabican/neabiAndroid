package br.edu.ifsc.neabiAndroid.data.local.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import br.edu.ifsc.neabiAndroid.domain.model.Address

@Entity(tableName = "address")
data class AddressEntity(
    @PrimaryKey
    val pk: Int,
    val city: String,
    val state: String,
    val public_place: String,
    val number: String,
    val zip_code: String,
    val latitude: String,
    val longitude: String
)