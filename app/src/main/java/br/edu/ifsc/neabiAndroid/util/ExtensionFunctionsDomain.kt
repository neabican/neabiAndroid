package br.edu.ifsc.neabiAndroid.util

import br.edu.ifsc.neabiAndroid.data.local.entities.*
import br.edu.ifsc.neabiAndroid.data.remote.dto.*
import br.edu.ifsc.neabiAndroid.domain.model.*


fun AddressEntity.toDomain(): Address {
    return Address(
        pk = pk,
        city = city,
        state = state,
        public_place = public_place,
        number = number,
        zip_code = zip_code,
        latitude = latitude,
        longitude = longitude
    )
}


fun AllCampusInfo.toDomain(): Campus {
    return Campus(
        pk = campus.pk,
        name = campus.name,
        link = campus.link,
        description = campus.description,
        institution = institution.toDomain(),
        address = address.toDomain(),
        courses = courses.toDomain(),
        image = image.toDomain(campus.pk),
        program = program.toDomain(),
        project = project.toDomain(),
        studentAssistence = studentAid.toDomain()
    )
}

fun CourseEntity.toDomain(): Course {
    return Course(
        pk = this.pk,
        name = this.name,
        description = this.description
    )
}

fun List<CourseEntity>.toDomain(): List<Course> {
    return map {
        it.toDomain()
    }
}

fun DBVersionDto.toDomain(): DBVersion {
    return DBVersion(
        pk = pk,
        version = version
    )
}

fun List<ProjectDto>.toEntity(): List<ProjectEntity> {
    return map {
        ProjectEntity(
            pk = it.pk,
            name = it.name,
            description = it.description,
            link = it.link,
            campusPk = it.campus,
        )
    }
}

@JvmName("toDomainCourseUnion")
fun List<CourseUnion>.toDomain(): List<Courses> {
    return map {
        Courses(
            pk = it.coursesEntity.pk,
            link = it.coursesEntity.link,
            addition_info = it.coursesEntity.addition_info,
            course = it.courseEntity.toDomain(),
            campus = it.coursesEntity.campusPk,
            vacancies = it.coursesEntity.vacancies
        )
    }
}

@JvmName("toDomainImageEntity")
fun List<ImageEntity>.toDomain(idCampus: Int): List<Image> {
    return map {
        Image(
            pk = it.pk,
            photo = it.photo,
            campus = idCampus
        )
    }
}

@JvmName("toDomainProgramEntity")
fun List<ProgramEntity>.toDomain(): List<Program> {
    return map {
        Program(
            pk = it.pk,
            name = it.name,
            description = it.description,
            link = it.link,
            campus = it.campusPk
        )
    }
}

@JvmName("toDomainProjectEntity")
fun List<ProjectEntity>.toDomain(): List<Project> {
    return map {
        Project(
            pk = it.pk,
            name = it.name,
            description = it.description,
            link = it.link,
            campus = it.campusPk
        )
    }
}

@JvmName("toDomainStudentAidEntity")
fun List<StudentAssistanceEntity>.toDomain(): List<StudentAssistence> {
    return map {
        StudentAssistence(
            pk = it.pk,
            name = it.name,
            description = it.description,
            link = it.link,
            campus = it.campusPk
        )
    }
}


