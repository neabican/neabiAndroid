package br.edu.ifsc.neabiAndroid

import android.app.Application
import br.edu.ifsc.neabiAndroid.data.local.NeabicanDatabase
import br.edu.ifsc.neabiAndroid.domain.repository.CampusRepository
import br.edu.ifsc.neabiAndroid.domain.repository.CoursesRepository
import br.edu.ifsc.neabiAndroid.domain.repository.HomeRepository
import br.edu.ifsc.neabiAndroid.domain.repository.InitializationRepository

class NeabiCanApplication: Application() {
    val neabicanDatabase: NeabicanDatabase by lazy{
        NeabicanDatabase.getInstance(this)
    }
    val coursesRepository: CoursesRepository by lazy {
        CoursesRepository(neabicanDatabase.coursesDao())
    }

    val initialRepository:InitializationRepository by lazy {
        InitializationRepository(neabicanDatabase)
    }

    val homeRepository:HomeRepository by lazy {
        HomeRepository(neabicanDatabase.campusDao())
    }

    val campusRepository: CampusRepository by lazy{
        CampusRepository(neabicanDatabase.campusDao())
    }
}