package br.edu.ifsc.aquilombar.domain.repository

import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.Build
import android.util.Log
import br.edu.ifsc.aquilombar.data.local.NeabicanDatabase
import br.edu.ifsc.aquilombar.data.remote.NeabicanApi
import br.edu.ifsc.aquilombar.util.DBMapper
import br.edu.ifsc.aquilombar.util.toDomain
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class InitializationRepository(private val db: NeabicanDatabase, private val connectivityManager: ConnectivityManager?) {

    suspend fun getLocalVersion(): Int{
        var version = -2
        try{
            version = db.DBVersionDao().getDatabaseVersion().version
        }catch (e: Exception){
            e.printStackTrace()
        }
        return version
    }

    suspend fun getApiVersion(): Int{
        Log.d("debug", "Collecting the DB version from API!")
        var version = if (hasInternet()) -1 else -2
        withContext(Dispatchers.IO){
            try {
                version = NeabicanApi.retrofitService.getDatabaseVersion().toDomain().version
            }catch (e: Exception) {
                Log.e("api", "Ocorreu um erro aco acessar API: "+e.message)
            }
        }
        return version
    }

    suspend fun clearDataBase(){
        try {
            db.addressDao().clearTable()
            Log.d("debug", "-> Clear Table Address!")
            db.studentAssistanceDao().clearTable()
            Log.d("debug", "-> Clear Table AddirmativeAction!")
            db.campusDao().clearTable()
            Log.d("debug", "-> Clear Table Campus!")
            db.courseDao().clearTable()
            Log.d("debug", "-> Clear Table Course!")
            db.coursesDao().clearTable()
            Log.d("debug", "-> Clear Table Courses!")
            db.institutionDao().clearTable()
            Log.d("debug", "-> Clear Table Institution!")
            db.imageDao().clearTable()
            Log.d("debug", "-> Clear Table Image!")
            db.programDao().clearTable()
            Log.d("debug", "-> Clear Table Program!")
            db.projectDao().clearTable()
            Log.d("debug", "-> Clear Table Project!")
            Log.d("debug", "-> DataBase Empty!!")
        }catch (e: Exception){
            Log.e("clear table", "Erro ao limpar banco: $e")
        }
    }

    suspend fun refreshDatabase(): Boolean{
        Log.d("debug", "Refreshing DataBase")

        withContext(Dispatchers.IO){
            clearDataBase()
            val mapper = DBMapper()
            try{
                Log.d("debug", "-> Getting data from the API")
                val aux = NeabicanApi.retrofitService.getInitialData()

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
                db.imageDao().insertAllImages(mapper.image)
                Log.d("debug", "-> Image insertion done!")
                db.programDao().insertAllProgram(mapper.program)
                Log.d("debug", "-> Program insertion done!")
                db.studentAssistanceDao().insertAllStudentAid(mapper.affirmativeAction)
                Log.d("debug", "-> Affirmative Action insertion done!")
                db.coursesDao().insertAllCourses(mapper.courses)
                Log.d("debug", "-> Institution insertion done!")
                db.projectDao().insertAllProjects(mapper.project)
                Log.d("debug", "-> Project insertion done!")
            }catch (e: Exception){
                Log.e("room", "Ocorreu um erro ao armazenar dados: ${e.message}")
                return@withContext false
            }
        }
        Log.d("debug", "DataBase insertion Completed")
        return true
    }

    private fun hasInternet():Boolean{
        return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            val network = connectivityManager?.activeNetwork ?: return false
            val capabilities = connectivityManager.getNetworkCapabilities(network)?:return false
            return capabilities.hasTransport(NetworkCapabilities.TRANSPORT_WIFI)
                    || capabilities.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR)
                    || capabilities.hasTransport(NetworkCapabilities.TRANSPORT_VPN)
        } else {
            val activateNetworkInfo = connectivityManager?.activeNetworkInfo
            if(activateNetworkInfo!=null){
                return activateNetworkInfo.type == ConnectivityManager.TYPE_WIFI
                        || activateNetworkInfo.type == ConnectivityManager.TYPE_MOBILE
            }
            false
        }
    }
}