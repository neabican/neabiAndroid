package br.edu.ifsc.neabiAndroid.data.remote.dto

import br.edu.ifsc.neabiAndroid.domain.model.Institution
import com.squareup.moshi.Json

class InstitutionDto(
    val pk: Int,

    @Json(name = "nome")
    val name: String,

    @Json(name = "sigla")
    val initials: String
){
    fun toDomain(): Institution{
        return Institution(
            pk = pk,
            name = name,
            initials = initials
        )
    }
}