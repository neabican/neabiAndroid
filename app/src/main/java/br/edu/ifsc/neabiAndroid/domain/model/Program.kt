package br.edu.ifsc.neabiAndroid.domain.model

import br.edu.ifsc.neabiAndroid.data.local.entities.ProgramEntity

data class Program(
    val pk: Int,
    val name: String,
    val description: String,
    val link: String,
    val campus: Int
)

fun List<Program>.asEntityModel(): List<ProgramEntity>{
    return map {
        ProgramEntity(
            pk = it.pk,
            name = it.name,
            description = it.description,
            link = it.link,
            campusPk = it.campus
        )
    }
}
