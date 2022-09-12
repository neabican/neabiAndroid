package br.edu.ifsc.neabiAndroid.domain.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import br.edu.ifsc.neabiAndroid.data.local.daos.CampusDao
import br.edu.ifsc.neabiAndroid.data.local.entities.HomeEntity
import br.edu.ifsc.neabiAndroid.data.local.entities.toDomain
import br.edu.ifsc.neabiAndroid.domain.model.Campus
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class HomeRepository(private val dao: CampusDao) {

    suspend fun getCampus(): LiveData<List<Campus>>{
        var campus: LiveData<List<Campus>>
        withContext(Dispatchers.Default){
            campus = Transformations.map(dao.getHomeInfo()){ homeInfo ->
                homeInfo.map {
                    Campus(
                        pk = it.campusEntity.pk,
                        name = it.campusEntity.name,
                        image = it.campusEntity.image,
                        institution = it.institution.toDomain(),
                        address = it.address.toDomain(),
                        courses = listOf(),
                        affirmativeAction = listOf(),
                        project = listOf(),
                        program = listOf()
                    )
                }
            }
        }
        return campus
    }
}