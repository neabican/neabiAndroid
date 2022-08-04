package br.edu.ifsc.neabiAndroid.domain.model

import br.edu.ifsc.neabiAndroid.data.local.entities.ProjectEntity

data class Project(
    val pk: Int,
    val name: String,
    val description: String,
    val link: String,
    val campus: Int
){
    fun toEntity(): ProjectEntity {
        return ProjectEntity(
            pk = pk,
            name = name,
            description = description,
            link = link,
            campusPk = campus
        )
    }
}
