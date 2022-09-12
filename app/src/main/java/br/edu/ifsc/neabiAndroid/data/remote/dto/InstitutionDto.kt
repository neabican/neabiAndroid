package br.edu.ifsc.neabiAndroid.data.remote.dto

import br.edu.ifsc.neabiAndroid.data.local.entities.InstitutionEntity
import br.edu.ifsc.neabiAndroid.domain.model.Institution
import com.squareup.moshi.Json

data class InstitutionDto(
    val pk: Int,

    @Json(name = "nome")
    val name: String,

    @Json(name = "sigla")
    val initials: String,

    val campus: List<CampusDto>
){
    fun toEntity(): InstitutionEntity{
        return InstitutionEntity(
            pk = pk,
            name = name,
            initials = initials,
        )
    }
}