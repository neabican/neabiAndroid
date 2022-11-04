package br.edu.ifsc.neabiAndroid.data.remote.dto

import br.edu.ifsc.neabiAndroid.data.local.entities.CampusEntity
import com.squareup.moshi.Json

data class CampusDto(
    val pk: Int,

    @Json(name = "nome")
    val name: String,

    @Json(name = "foto")
    val image: String = "",

    val link: String = "",

    @Json(name = "instituicao")
    val institution: Int,

    @Json(name = "endereco")
    val addressDto: AddressDto,

    @Json(name = "cursos")
    val courses: List<CoursesDto> = listOf(),

    @Json(name = "programas")
    val programDto: List<ProgramDto> = listOf(),

    @Json(name = "projetos")
    val projectDto: List<ProjectDto> = listOf(),

    @Json(name = "acoes_afirmativas")
    val studentAidDto: List<StudentAidDto> = listOf(),
){
    fun toEntity(): CampusEntity {
        return CampusEntity(
            pk = pk,
            name = name,
            image = image,
            link = link,
            institutionPk = institution,
            addressPk = addressDto.pk
        )
    }
}