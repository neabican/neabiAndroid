package br.edu.ifsc.neabiAndroid.domain.model

import br.edu.ifsc.neabiAndroid.data.local.entities.AffirmativeActionEntity

data class AffirmativeAction(
    val pk: Int,
    val name: String,
    val description: String,
    val link: String,
    val campus: Int
)