package br.edu.ifsc.neabiAndroid.domain.repository

import br.edu.ifsc.neabiAndroid.data.local.daos.CampusDao
import br.edu.ifsc.neabiAndroid.domain.model.Campus
import br.edu.ifsc.neabiAndroid.util.Resource
import br.edu.ifsc.neabiAndroid.util.toDomain
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
                        image = it.campusEntity.image,
                        link = it.campusEntity.link,
                        institution = it.institution.toDomain(),
                        address = it.address.toDomain(),
                        description = it.campusEntity.description
                    )
                }
            )
        }
    }
}