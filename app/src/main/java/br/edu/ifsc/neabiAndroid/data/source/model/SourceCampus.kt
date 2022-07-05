package br.edu.ifsc.neabiAndroid.data.source.model

import com.squareup.moshi.Json

data class SourceCampus(
    val pk: Int,

    @Json(name = "nome")
    val name: String,

    @Json(name = "instituicao")
    val sourceInstitution: SourceInstitution,

    @Json(name = "endereco")
    val sourceAddress: SourceAddress,

    @Json(name = "cursos")
    val cours: List<SourceCourses> = listOf(),

    @Json(name = "programas")
    val sourceProgram: List<SourceProgram> = listOf(),

    @Json(name = "projetos")
    val sourceProject: List<SourceProject> = listOf(),

    @Json(name = "acoes_afirmativas")
    val sourceAffirmativeAction: List<SourceAffirmativeAction> = listOf(),
)