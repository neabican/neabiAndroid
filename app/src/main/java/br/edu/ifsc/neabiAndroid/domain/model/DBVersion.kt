package br.edu.ifsc.neabiAndroid.domain.model

import br.edu.ifsc.neabiAndroid.data.local.entities.DBVersionEntity

data class DBVersion(
    val pk: Int = 0,
    val version: Int = 0
)

fun DBVersion.toEntity(): DBVersionEntity{
    return DBVersionEntity(
        pk = pk,
        version = version
    )
}
