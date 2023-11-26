package br.edu.ifsc.neabiAndroid.domain.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import br.edu.ifsc.neabiAndroid.data.local.daos.CampusDao
import br.edu.ifsc.neabiAndroid.domain.model.Campus
import br.edu.ifsc.neabiAndroid.util.EmptyClass
import br.edu.ifsc.neabiAndroid.util.toDomain
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class CampusRepository(private val dao: CampusDao) {

    suspend fun getCampusByListOfPk(list: List<Int>): List<Campus> {
        return dao.getCampusByPk(list).map {
            Campus(
                pk = it.pk,
                name = it.name,
                link = it.link,
                description = it.description,
                address = EmptyClass.emptyAddress,
                institution = EmptyClass.emptyInstitution
            )
        }
    }

    suspend fun getCampus(campusPk: Int): LiveData<Campus> {
        var campus: LiveData<Campus>
        withContext(Dispatchers.Default) {
            campus = Transformations.map(dao.getCampus(campusPk)) {
                Campus(
                    pk = it.campus.pk,
                    name = it.campus.name,
                    link = it.campus.link,
                    institution = it.institution.toDomain(),
                    address = it.address.toDomain(),
                    description = it.campus.description,
                    courses = it.courses.toDomain(),
                    image = it.image.toDomain(it.campus.pk),
                    program = it.program.toDomain(),
                    project = it.project.toDomain(),
                    studentAssistence = it.studentAid.toDomain()
                )
            }
        }
        return campus
    }
}