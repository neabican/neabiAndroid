package br.edu.ifsc.aquilombar.data.local.entities

import androidx.room.Embedded
import androidx.room.Relation

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
    val studentAid: List<StudentAssistanceEntity>,
    @Relation(
        parentColumn = "pk",
        entityColumn = "campusPk"
    )
    val image: List<ImageEntity>
)