package br.edu.ifsc.neabiAndroid.data.local.entities

import androidx.room.Embedded
import androidx.room.Relation
import br.edu.ifsc.neabiAndroid.domain.model.Campus
import br.edu.ifsc.neabiAndroid.util.toDomain

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
        entity = CoursesEntity::class,
        parentColumn = "pk",
        entityColumn = "campusPk"
    )
    val courses: List<CourseUnion>,
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
    val studentAid: List<StudentAidEntity>
)