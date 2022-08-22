package br.edu.ifsc.neabiAndroid.domain.model

import br.edu.ifsc.neabiAndroid.data.local.entities.ProgramEntity
import br.edu.ifsc.neabiAndroid.data.local.entities.ProjectEntity

data class Project(
    val pk: Int,
    val name: String,
    val description: String,
    val link: String,
    val campus: Int
)

fun List<Project>.asEntityModel(): List<ProjectEntity>{
    return map{
        ProjectEntity(
            pk = it.pk,
            name = it.name,
            description = it.description,
            link = it.link,
            campusPk = it.campus
        )
    }
}
