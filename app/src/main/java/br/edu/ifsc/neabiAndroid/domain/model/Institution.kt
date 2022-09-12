package br.edu.ifsc.neabiAndroid.domain.model

import br.edu.ifsc.neabiAndroid.data.local.entities.InstitutionEntity

data class Institution(
    val pk: Int,
    val name: String,
    val initials: String,
    val campus: List<Campus>
)