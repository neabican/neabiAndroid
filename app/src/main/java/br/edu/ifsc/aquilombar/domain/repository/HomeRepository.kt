package br.edu.ifsc.aquilombar.domain.repository

import br.edu.ifsc.aquilombar.data.local.daos.CampusDao
import br.edu.ifsc.aquilombar.domain.model.Campus
import br.edu.ifsc.aquilombar.util.toDomain
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class HomeRepository(private val dao: CampusDao) {

     fun getCampus(): Flow<List<Campus>>{
        return flow {
            val homeInfo = dao.getHomeInfo()
            emit(
                 homeInfo.map {
                    Campus(
                        pk = it.campusEntity.pk,
                        name = it.campusEntity.name,
                        link = it.campusEntity.link,
                        institution = it.institution.toDomain(),
                        address = it.address.toDomain(),
                        description = it.campusEntity.description,
                        image = it.image.toDomain(it.campusEntity.pk)

                    )
                }
            )
        }
    }
}