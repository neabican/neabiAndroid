package br.edu.ifsc.neabiAndroid.util

import br.edu.ifsc.neabiAndroid.data.local.entities.*
import br.edu.ifsc.neabiAndroid.data.remote.dto.InstitutionDto

class DBMapper() {
    var address: MutableList<AddressEntity> = mutableListOf()
    var affirmativeAction: MutableList<StudentAssistanceEntity> = mutableListOf()
    var campus: MutableList<CampusEntity> = mutableListOf()
    var course: MutableList<CourseEntity> = mutableListOf()
    var courses: MutableList<CoursesEntity> = mutableListOf()
    var institution: MutableList<InstitutionEntity> = mutableListOf()
    var program: MutableList<ProgramEntity> = mutableListOf()
    var project: MutableList<ProjectEntity> = mutableListOf()
    var mapDone = false

    fun cast(data: List<InstitutionDto>){
        institution.addAll(data.map { it.toEntity() })
        for (item in data){
            campus.addAll(item.campus.map { it.toEntity() })
            item.campus.map {
                address.add(it.addressDto.toEntity())
                affirmativeAction.addAll(it.studentAssistanceDto.toEntity())
                courses.addAll(it.courses.toEntity(it.pk))
                course.addAll(
                    it.courses.map { index ->
                        index.courseDto.toEntity()
                    }
                )
                program.addAll(it.programDto.toEntity())
                project.addAll(it.projectDto.toEntity())
            }
            course.distinct()
            project.distinct()
            project.distinct()
            affirmativeAction.distinct()
        }
        mapDone = true
    }
}