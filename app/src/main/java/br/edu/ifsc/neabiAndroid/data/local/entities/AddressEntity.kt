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

fun AddressEntity.toDomain(): Address{
    return Address(
        pk = pk,
        city = city,
        state = state,
        public_place = public_place,
        number = number,
        zip_code = zip_code,
        latitude = latitude,
        longitude = longitude
    )
}