package br.edu.ifsc.neabiAndroid.domain.model

import br.edu.ifsc.neabiAndroid.data.local.entities.AddressEntity

data class Address(
    val pk: Int,
    val city: String,
    val state: String,
    val public_place: String,
    val number: String,
    val zip_code: String,
    val latitude: String,
    val longitude: String
){
    fun toEntity(): AddressEntity {
        return AddressEntity(
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
}
