package br.edu.ifsc.neabiAndroid.data.remote.dto

import br.edu.ifsc.neabiAndroid.data.local.entities.ImageEntity
import com.squareup.moshi.Json

data class ImageDto(
    val pk: Int,

    @Json(name = "foto")
    val photo: String,
) {
    fun toEntity(idCampus: Int): ImageEntity {
        return ImageEntity(
            pk = pk,
            photo = photo,
            campusPk = idCampus
        )
    }
}