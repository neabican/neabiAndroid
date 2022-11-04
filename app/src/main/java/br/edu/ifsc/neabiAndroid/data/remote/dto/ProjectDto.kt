package br.edu.ifsc.neabiAndroid.data.remote.dto

import br.edu.ifsc.neabiAndroid.data.local.entities.ProjectEntity
import br.edu.ifsc.neabiAndroid.domain.model.Project
import com.squareup.moshi.Json

data class ProjectDto(
    val pk: Int,

    @Json(name = "nome")
    val name: String,

    @Json(name = "descricao")
    val description: String,

    val link: String,
    val campus: Int
)
