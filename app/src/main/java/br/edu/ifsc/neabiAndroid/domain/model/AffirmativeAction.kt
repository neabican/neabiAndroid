package br.edu.ifsc.neabiAndroid.domain.model

import br.edu.ifsc.neabiAndroid.data.local.entities.AffirmativeActionEntity

data class AffirmativeAction(
    val pk: Int,
    val name: String,
    val description: String,
    val link: String,
    val campus: Int
)

fun List<AffirmativeAction>.asEntityModel() : List<AffirmativeActionEntity>{
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
