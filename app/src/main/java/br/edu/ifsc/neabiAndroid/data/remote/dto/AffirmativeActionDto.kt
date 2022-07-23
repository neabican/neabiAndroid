package br.edu.ifsc.neabiAndroid.data.remote.dto

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
    fun toDomain(): AffirmativeAction{
        return AffirmativeAction(
            pk = pk,
            name = name,
            description = description,
            link = link,
            campus = campus
        )
    }
}
