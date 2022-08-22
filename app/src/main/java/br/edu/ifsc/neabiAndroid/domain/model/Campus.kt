package br.edu.ifsc.neabiAndroid.domain.model

import br.edu.ifsc.neabiAndroid.data.local.entities.CampusEntity

data class Campus(
    val pk: Int,
    val name: String,
    val image: String,
    val institution: Int,
    val address: Address,
    val courses: List<Courses>,
    val program: List<Program>,
    val project: List<Project>,
    val affirmativeAction: List<AffirmativeAction>,
)

fun List<Campus>.asEntityModel(): List<CampusEntity>{
    return map {
        CampusEntity(
            pk = it.pk,
            name = it.name,
            image = it.image,
            institutionPk = it.institution,
            addressPk = it.address.pk
        )
    }
}
