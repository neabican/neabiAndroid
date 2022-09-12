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

    suspend fun getApiVersion(): DBVersion{
        Log.d("debug", "Collecting the DB version from API!")

        var version = DBVersion(6,6)
        withContext(Dispatchers.IO){
            try {
                version = NeabicanApi.retrofitService.getDatabaseVersion().toDomain()
            }catch (e: Exception){
                Log.e("api", "Ocorreu um erro aco acessar API: "+e.message)
            }
        }
        return version
    }

    suspend fun refreshDatabase(): Boolean{
        Log.d("debug", "Refreshing DataBase")

        withContext(Dispatchers.IO){
            var mapper = DBMapper()
            try{
                Log.d("debug", "-> Getting data from the API")
                var aux = NeabicanApi.retrofitService.getInitialData()

                Log.d("debug", "-> Starting the data map!")
                mapper.cast(aux)
            }catch (e: Exception){
                Log.e("api", "Ocorreu um erro ao acessar API: "+e.message)
                return@withContext false
            }

            Log.d("debug", "-> Get the data from API and map done!")
            try{
                db.institutionDao().insertAllInstitutions(mapper.institution)
                Log.d("debug", "-> Institution insertion done!")
                db.courseDao().insertAllCourse(mapper.course)
                Log.d("debug", "-> Course insertion done!")
                db.addressDao().insertAllAddress(mapper.address)
                Log.d("debug", "-> Address insertion done!")
                db.campusDao().insertAllCampus(mapper.campus)
                Log.d("debug", "-> Campus insertion done!")
                db.programDao().insertAllProgram(mapper.program)
                Log.d("debug", "-> Program insertion done!")
                db.affirmaticeActionDao().insertAllAffitmativeActions(mapper.affirmativeAction)
                Log.d("debug", "-> Affirmative Action insertion done!")
                db.coursesDao().insertAllCourses(mapper.courses)
                Log.d("debug", "-> Institution insertion done!")
                db.project().insertAllProjects(mapper.project)
                Log.d("debug", "-> Project insertion done!")
            }catch (e: Exception){
                Log.e("room", "Ocorreu um erro ao armazenar dados: ${e.message}")
                return@withContext false
            }
        }
        Log.d("debug", "DataBase insertion Completed")
        return true
    }
}