package br.edu.ifsc.neabiAndroid.data.local.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import br.edu.ifsc.neabiAndroid.domain.model.Institution

@Entity(tableName = "institution")
data class InstitutionEntity(
    @PrimaryKey
    val pk: Int,
    val name: String,
    val initials: String
){
    fun toDomain(): Institution{
        return Institution(
            pk = pk,
            name = name,
            initials = initials,
            campus = listOf()
        )
    }
}
