package br.edu.ifsc.neabiAndroid.domain.repository

import android.util.Log
import br.edu.ifsc.neabiAndroid.data.local.NeabicanDatabase
import br.edu.ifsc.neabiAndroid.data.remote.NeabicanApi
import br.edu.ifsc.neabiAndroid.domain.model.Institution
import br.edu.ifsc.neabiAndroid.util.DBMapper

class InitializationRepository(private val db: NeabicanDatabase) {

    suspend fun getInstances(): List<Institution>{
        try{
            var aux = NeabicanApi.retrofitService.getInitialData()
            val mapper = DBMapper(aux.map { it.toDomain() })
            Thread.sleep(3000L)
            db.institutionDao().insertAllInstitutions(mapper.institution)
            db.courseDao().insertAllCourse(mapper.course)
            db.addressDao().insertAllAddress(mapper.address)
            db.campusDao().insertAllCampus(mapper.campus)
            db.programDao().insertAllProgram(mapper.program)
            db.affirmaticeActionDao().insertAllAffitmativeActions(mapper.affirmativeAction)
            db.coursesDao().insertAllCourses(mapper.courses)
            db.project().insertAllProjects(mapper.project)
        }catch (e: Exception){
            Log.e("api", "Ocorreu um erro"+e.message)
        }
        return listOf()
    }
}