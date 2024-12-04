package br.edu.ifsc.aquilombar.data.local.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import br.edu.ifsc.aquilombar.domain.model.Institution

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
