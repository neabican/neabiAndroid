package br.edu.ifsc.neabiAndroid.data.local.entities

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.ForeignKey.CASCADE
import androidx.room.ForeignKey.RESTRICT
import androidx.room.PrimaryKey
import br.edu.ifsc.neabiAndroid.domain.model.AffirmativeAction

@Entity(
    tableName = "affirmativeAction",
    foreignKeys = [
        ForeignKey(
            entity = CampusEntity::class,
            parentColumns = arrayOf("pk"),
            childColumns = arrayOf("campusPk"),
            onDelete = CASCADE,
            onUpdate = CASCADE
        )
    ]
)
data class AffirmativeActionEntity(
    @PrimaryKey
    val pk: Int,
    val name: String,
    val description: String,
    val link: String,
    val campusPk: Int
)

fun List<AffirmativeActionEntity>.toDomain(): List<AffirmativeAction>{
    return map{
        AffirmativeAction(
            pk = it.pk,
            name = it.name,
            description = it.description,
            link = it.link,
            campus = it.campusPk
        )
    }
}
