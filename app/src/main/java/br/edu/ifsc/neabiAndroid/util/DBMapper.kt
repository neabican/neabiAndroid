package br.edu.ifsc.neabiAndroid.util

import br.edu.ifsc.neabiAndroid.data.local.entities.*
import br.edu.ifsc.neabiAndroid.domain.model.Campus
import br.edu.ifsc.neabiAndroid.domain.model.Institution
import br.edu.ifsc.neabiAndroid.domain.model.asEntityModel

class DBMapper(data: List<Institution>) {
    var address: MutableList<AddressEntity> = mutableListOf()
    var affirmativeAction: MutableList<AffirmativeActionEntity> = mutableListOf()
    var campus: MutableList<CampusEntity> = mutableListOf()
    var course: MutableList<CourseEntity> = mutableListOf()
    var courses: MutableList<CoursesEntity> = mutableListOf()
    var institution: MutableList<InstitutionEntity> = mutableListOf()
    var program: MutableList<ProgramEntity> = mutableListOf()
    var project: MutableList<ProjectEntity> = mutableListOf()

    init {
        institution.addAll(data.map { it.toEntity() })
        for (items in data){
            campus.addAll(items.campus.asEntityModel())
            items.campus.map {
                address.add(it.address.toEntity())
                affirmativeAction.addAll(it.affirmativeAction.asEntityModel())
                courses.addAll(it.courses.asEntityModel())
                course.addAll(
                    it.courses.map { index ->
                        index.course.toEntity()
                    }
                )
                program.addAll(it.program.asEntityModel())
                project.addAll(it.project.asEntityModel())
            }
            course.distinct()
            project.distinct()
            project.distinct()
            affirmativeAction.distinct()
        }
    }
}