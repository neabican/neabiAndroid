package br.edu.ifsc.neabiAndroid.domain.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import br.edu.ifsc.neabiAndroid.data.local.daos.CampusDao
import br.edu.ifsc.neabiAndroid.data.local.entities.AllCampusInfo
import br.edu.ifsc.neabiAndroid.data.local.entities.CampusEntity
import br.edu.ifsc.neabiAndroid.data.local.entities.toDomain
import br.edu.ifsc.neabiAndroid.data.local.entities.toDomainCampus
import br.edu.ifsc.neabiAndroid.domain.model.Campus

class CampusRepository(private val dao: CampusDao) {

    val campus: LiveData<Campus> = MutableLiveData()

    fun getCampus(campusPk:Int): LiveData<Campus> {
        return MutableLiveData()
    }


        /**
            ){
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
         **/
}