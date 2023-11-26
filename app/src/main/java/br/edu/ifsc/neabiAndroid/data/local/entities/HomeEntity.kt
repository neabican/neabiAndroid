package br.edu.ifsc.neabiAndroid.data.local.entities

import androidx.room.Embedded
import androidx.room.Relation
import br.edu.ifsc.neabiAndroid.domain.model.Institution

data class HomeEntity(
    @Embedded val campusEntity: CampusEntity,
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
    val image: List<ImageEntity>
)
