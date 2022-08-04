package br.edu.ifsc.neabiAndroid.util

import br.edu.ifsc.neabiAndroid.data.local.entities.*
import br.edu.ifsc.neabiAndroid.domain.model.Campus

class DBMapper(data: List<Campus>) {
    var address: List<AddressEntity> = mutableListOf()
    var affirmativeAction: List<AffirmativeActionEntity> = mutableListOf()
    var campus: List<CampusEntity> = mutableListOf()
    var course: List<CourseEntity> = mutableListOf()
    var couses: List<CoursesEntity> = mutableListOf()
    var institution: List<InstitutionEntity> = mutableListOf()
    var program: List<ProgramEntity> = mutableListOf()
    var project: List<ProjectEntity> = mutableListOf()

    init {
        address = data.map { it.address.toEntity() }.distinct()
        campus = data.map { it.toEntity() }.distinct()
        institution = data.map { it.institution.toEntity() }.distinct()
        for(item in data){
            affirmativeAction = item.affirmativeAction.map { it.toEntity() }
            course = item.courses.map { it.course.toEntity() }
            couses = item.courses.map { it.toEntity() }
            program = item.program.map { it.toEntity() }
            project = item.project.map { it.toEntity() }
        }
    }
}