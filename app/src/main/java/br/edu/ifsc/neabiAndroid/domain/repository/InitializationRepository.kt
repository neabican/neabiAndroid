package br.edu.ifsc.neabiAndroid.domain.repository

import android.util.Log
import br.edu.ifsc.neabiAndroid.data.local.NeabicanDatabase
import br.edu.ifsc.neabiAndroid.data.local.entities.asDomain
import br.edu.ifsc.neabiAndroid.data.remote.NeabicanApi
import br.edu.ifsc.neabiAndroid.data.remote.dto.toDomain
import br.edu.ifsc.neabiAndroid.domain.model.DBVersion
import br.edu.ifsc.neabiAndroid.util.DBMapper
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class InitializationRepository(private val db: NeabicanDatabase) {
    val version: DBVersion = db.DBVersionDao().getDatabaseVersion().asDomain()

    suspend fun getApiVersion(): DBVersion{
        withContext(Dispatchers.IO){
            try {
                var version = NeabicanApi.retrofitService.getDatabaseVersion().toDomain()
            }catch (e: Exception){
                Log.e("api", "Ocorreu um erro aco acessar API: "+e.message)
            }
        }
        return version
    }

    suspend fun refreshDatabase(): Boolean{
        withContext(Dispatchers.IO){
            var mapper = DBMapper()
            try{
                var aux = NeabicanApi.retrofitService.getInitialData()
                mapper.cast(aux.map { it.toDomain() })
            }catch (e: Exception){
                Log.e("api", "Ocorreu um erro ao acessar API: "+e.message)
                return@withContext false
            }

            try{
                db.institutionDao().insertAllInstitutions(mapper.institution)
                db.courseDao().insertAllCourse(mapper.course)
                db.addressDao().insertAllAddress(mapper.address)
                db.campusDao().insertAllCampus(mapper.campus)
                db.programDao().insertAllProgram(mapper.program)
                db.affirmaticeActionDao().insertAllAffitmativeActions(mapper.affirmativeAction)
                db.coursesDao().insertAllCourses(mapper.courses)
                db.project().insertAllProjects(mapper.project)
            }catch (e: Exception){
                Log.e("room", "Ocorreu um erro ao armazenar dados: ${e.message}")
                return@withContext false
            }
        }
        return true
    }
}