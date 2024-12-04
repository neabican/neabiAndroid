package br.edu.ifsc.aquilombar.data.remote.dto

import br.edu.ifsc.aquilombar.data.local.entities.CampusEntity
import com.squareup.moshi.Json

data class CampusDto(
    val pk: Int,

    @Json(name = "nome")
    val name: String,

    val link: String = "",

    @Json(name = "instituicao")
    val institution: Int,

    @Json(name = "endereco")
    val addressDto: AddressDto,

    @Json(name = "descricao")
    val description: String,

    @Json(name = "cursos")
    val courses: List<CoursesDto> = listOf(),

    @Json(name = "fotos")
    val imageDto: List<ImageDto> = listOf(),

    @Json(name = "programas")
    val programDto: List<ProgramDto> = listOf(),

    @Json(name = "projetos")
    val projectDto: List<ProjectDto> = listOf(),

    @Json(name = "acoes_afirmativas")
    val studentAssistanceDto: List<StudentAssistanceDto> = listOf(),
) {
    fun toEntity(): CampusEntity {
        return CampusEntity(
            pk = pk,
            name = name,
            link = link,
            institutionPk = institution,
            addressPk = addressDto.pk,
            description = description
        )
    }
}