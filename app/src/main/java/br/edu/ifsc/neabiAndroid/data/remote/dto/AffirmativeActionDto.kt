package br.edu.ifsc.neabiAndroid.data.remote.dto

import br.edu.ifsc.neabiAndroid.data.local.entities.AffirmativeActionEntity
import br.edu.ifsc.neabiAndroid.domain.model.AffirmativeAction
import com.squareup.moshi.Json

data class AffirmativeActionDto(
    val pk: Int,

    @Json(name = "nome")
    val name: String,

    @Json(name = "descricao")
    val description: String,

    val link: String = "",
    val campus: Int
){
    fun toEntity(): AffirmativeActionEntity{
        return AffirmativeActionEntity(
            pk = pk,
            name = name,
            description = description,
            link = link,
            campusPk = campus
        )
    }
}

fun List<AffirmativeActionDto>.toEntity(): List<AffirmativeActionEntity>{
    return map{
        AffirmativeActionEntity(
            pk = it.pk,
            name = it.name,
            description = it.description,
            link = it.link,
            campusPk = it.campus
        )
    }
}
