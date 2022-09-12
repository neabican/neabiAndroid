package br.edu.ifsc.neabiAndroid.domain.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import br.edu.ifsc.neabiAndroid.data.local.daos.CampusDao
import br.edu.ifsc.neabiAndroid.data.local.entities.toDomain
import br.edu.ifsc.neabiAndroid.domain.model.Campus
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class CampusRepository(private val dao: CampusDao) {

    suspend fun getCampus(campusPk:Int): LiveData<Campus> {
        var campus: LiveData<Campus>
        withContext(Dispatchers.Default){
            campus = Transformations.map(dao.getCampus(campusPk)){
                Campus(
                    pk = it.campus.pk,
                    name = it.campus.name,
                    image = it.campus.image,
                    institution = it.institution.toDomain(),
                    address = it.address.toDomain(),
                    courses = it.courses.toDomain(),
                    program = it.program.toDomain(),
                    project = it.project.toDomain(),
                    affirmativeAction = it.affirmativeAction.toDomain()
                )
            }
        }
        return campus
    }
}