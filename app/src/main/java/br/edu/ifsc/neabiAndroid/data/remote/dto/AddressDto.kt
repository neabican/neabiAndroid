package br.edu.ifsc.neabiAndroid.data.remote.dto

import br.edu.ifsc.neabiAndroid.domain.model.Address
import com.squareup.moshi.Json

data class AddressDto(

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

    //String? Será necessario fazer o calculo de distancia?
    val latitude: String,
    val longitude: String
){
    fun toDomain(): Address{
        return Address(
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
