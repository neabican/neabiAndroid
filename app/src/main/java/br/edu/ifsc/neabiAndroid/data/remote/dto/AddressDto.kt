package br.edu.ifsc.neabiAndroid.data.remote.dto

import br.edu.ifsc.neabiAndroid.data.local.entities.AddressEntity
import br.edu.ifsc.neabiAndroid.domain.model.Address
import com.squareup.moshi.Json

data class AddressDto(
    val pk: Int,

    @Json(name="cidade")
    val city: String,

    @Json(name = "estado")
    val state: String,

    @Json(name = "logradouro")
    val public_place: String,

    @Json(name = "numero")
    val number: String,

    @Json(name = "cep")
    val zip_code: String,

    val latitude: String,

    val longitude: String
){
    fun toEntity(): AddressEntity{
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
