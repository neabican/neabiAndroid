package br.edu.ifsc.aquilombar.util

import br.edu.ifsc.aquilombar.data.local.entities.CoursesEntity
import br.edu.ifsc.aquilombar.data.local.entities.ImageEntity
import br.edu.ifsc.aquilombar.data.local.entities.ProgramEntity
import br.edu.ifsc.aquilombar.data.local.entities.StudentAssistanceEntity
import br.edu.ifsc.aquilombar.data.remote.dto.CoursesDto
import br.edu.ifsc.aquilombar.data.remote.dto.ImageDto
import br.edu.ifsc.aquilombar.data.remote.dto.ProgramDto
import br.edu.ifsc.aquilombar.data.remote.dto.StudentAssistanceDto

fun List<CoursesDto>.toEntity(campusPk: Int): List<CoursesEntity>{
    return map{
        CoursesEntity(
            pk = it.pk,
            link = it.link,
            addition_info = it.addition_info,
            coursePk = it.courseDto.pk,
            campusPk = campusPk,
            vacancies = it.vacancies
        )
    }
}

@JvmName("toEntityStudentAidDto")
fun List<StudentAssistanceDto>.toEntity(): List<StudentAssistanceEntity>{
    return map{
        StudentAssistanceEntity(
            pk = it.pk,
            name = it.name,
            description = it.description,
            link = it.link,
            campusPk = it.campus
        )
    }
}

@JvmName("toEntityImageDto")
fun List<ImageDto>.toEntity(idCampus: Int): List<ImageEntity> {
    return map {
        ImageEntity(
            pk = it.pk,
            photo = it.photo,
            campusPk = idCampus
        )
    }
}

@JvmName("toEntityProgramDto")
fun List<ProgramDto>.toEntity(): List<ProgramEntity>{
    return map{
        ProgramEntity(
            pk = it.pk,
            name = it.name,
            description = it.description,
            link = it.link,
            campusPk = it.campus
        )
    }
}