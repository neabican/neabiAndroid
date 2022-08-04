package br.edu.ifsc.neabiAndroid.domain.model

import br.edu.ifsc.neabiAndroid.data.local.entities.CampusEntity

data class Campus(
    val pk: Int,
    val name: String,
    val image: String,
    val institution: Institution,
    val address: Address,
    val courses: List<Courses>,
    val program: List<Program>,
    val project: List<Project>,
    val affirmativeAction: List<AffirmativeAction>,
){
    fun toEntity(): CampusEntity {
        return CampusEntity(
            pk = pk,
            name = name,
            image = image,
            institutionPk = institution.pk,
            addressPk = address.pk
        )
    }
}