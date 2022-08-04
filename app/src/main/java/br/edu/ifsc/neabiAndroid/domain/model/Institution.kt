package br.edu.ifsc.neabiAndroid.domain.model

import br.edu.ifsc.neabiAndroid.data.local.entities.InstitutionEntity

class Institution(
    val pk: Int,
    val name: String,
    val initials: String
){
    fun toEntity(): InstitutionEntity {
        return InstitutionEntity(
            pk = pk,
            name = name,
            initials = initials
        )
    }
}