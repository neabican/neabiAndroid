package br.edu.ifsc.neabiAndroid.data.local.entities

import androidx.room.Embedded
import androidx.room.Relation
import br.edu.ifsc.neabiAndroid.domain.model.Campus

data class AllCampusInfo(
    @Embedded val campus: CampusEntity,
    @Relation(
        parentColumn = "institutionPk",
        entityColumn = "pk",
    )
    val institution: InstitutionEntity,
    @Relation(
        parentColumn = "addressPk",
        entityColumn = "pk"
    )
    val address: AddressEntity,
    @Relation(
        parentColumn = "pk",
        entityColumn = "campusPk"
    )
    val courses: List<CoursesEntity>,
    @Relation(
        parentColumn = "pk",
        entityColumn = "campusPk"
    )
    val program: List<ProgramEntity>,
    @Relation(
        parentColumn = "pk",
        entityColumn = "campusPk"
    )
    val project: List<ProjectEntity>,
    @Relation(
        parentColumn = "pk",
        entityColumn = "campusPk"
    )
    val affirmativeAction: List<AffirmativeActionEntity>
)

fun AllCampusInfo.toDomainCampus(): Campus{
    return Campus(
        pk = campus.pk,
        name = campus.name,
        image = campus.image,
        institution = institution.toDomain(),
        address = address.toDomain(),
        courses = courses.toDomain(),
        program = program.toDomain(),
        project = project.toDomain(),
        affirmativeAction = affirmativeAction.toDomain()
    )
}