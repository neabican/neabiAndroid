package br.edu.ifsc.neabiAndroid

import android.app.Application
import android.net.ConnectivityManager
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.core.content.ContextCompat
import br.edu.ifsc.neabiAndroid.data.local.NeabicanDatabase
import br.edu.ifsc.neabiAndroid.domain.repository.*

@RequiresApi(Build.VERSION_CODES.M)
class NeabiAndroid: Application() {
    val neabicanDatabase: NeabicanDatabase by lazy{
        NeabicanDatabase.getInstance(this)
    }

    val courseRepository: CourseRepository by lazy{
        CourseRepository(neabicanDatabase.courseDao())
    }

    val coursesRepository: CoursesRepository by lazy {
        CoursesRepository(neabicanDatabase.coursesDao())
    }

    val initialRepository:InitializationRepository by lazy {
        InitializationRepository(neabicanDatabase, ContextCompat.getSystemService(this, ConnectivityManager::class.java))
    }

    val homeRepository:HomeRepository by lazy {
        HomeRepository(neabicanDatabase.campusDao())
    }

    val campusRepository: CampusRepository by lazy{
        CampusRepository(neabicanDatabase.campusDao())
    }
}