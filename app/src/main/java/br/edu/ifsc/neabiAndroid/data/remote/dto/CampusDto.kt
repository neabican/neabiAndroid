package br.edu.ifsc.neabiAndroid.data.remote.dto

import br.edu.ifsc.neabiAndroid.domain.model.Campus
import com.squareup.moshi.Json

data class CampusDto(
    val pk: Int,

    @Json(name = "nome")
    val name: String,

    @Json(name = "photo")
    val image: String,

    @Json(name = "instituicao")
    val institutionDto: InstitutionDto,

    @Json(name = "endereco")
    val addressDto: AddressDto,

    @Json(name = "cursos")
    val courses: List<CoursesDto> = listOf(),

    @Json(name = "programas")
    val programDto: List<ProgramDto> = listOf(),

    @Json(name = "projetos")
    val projectDto: List<ProjectDto> = listOf(),

    @Json(name = "acoes_afirmativas")
    val affirmativeActionDto: List<AffirmativeActionDto> = listOf(),
){
    fun toDomain(): Campus {
        return Campus(
            pk = pk,
            name = name,
            image = image,
            institution = institutionDto.toDomain(),
            address = addressDto.toDomain(),
            courses = courses.map { it.toDomain(pk) },
            program = programDto.map { it.toDomain() },
            project = projectDto.map { it.toDomain() },
            affirmativeAction = affirmativeActionDto.map{ it.toDomain() }
        )
    }
}