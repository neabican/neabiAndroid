package br.edu.ifsc.neabiAndroid.domain.model

import br.edu.ifsc.neabiAndroid.data.local.entities.ProgramEntity

data class Program(
    val pk: Int,
    val name: String,
    val description: String,
    val link: String,
    val campus: Int
)
