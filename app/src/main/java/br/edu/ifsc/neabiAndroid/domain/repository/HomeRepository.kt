package br.edu.ifsc.neabiAndroid.domain.repository

import br.edu.ifsc.neabiAndroid.data.local.daos.CampusDao
import br.edu.ifsc.neabiAndroid.data.local.entities.toDomain
import br.edu.ifsc.neabiAndroid.domain.model.Campus
import br.edu.ifsc.neabiAndroid.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class HomeRepository(private val dao: CampusDao) {

     fun getCampus(): Flow<Resource<List<Campus>>>{
        return flow {
            emit(Resource.Loading(isLoading = true))
            val homeInfo = dao.getHomeInfo()
            emit(
                Resource.Success(
                    data = homeInfo.map {
                        Campus(
                            pk = it.campusEntity.pk,
                            name = it.campusEntity.name,
                            image = it.campusEntity.image,
                            link = it.campusEntity.link,
                            institution = it.institution.toDomain(),
                            address = it.address.toDomain()
                        )
                    }
                )
            )
        }
    }
}