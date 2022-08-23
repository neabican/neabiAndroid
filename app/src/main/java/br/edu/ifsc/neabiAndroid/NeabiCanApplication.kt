package br.edu.ifsc.neabiAndroid

import android.app.Application
import br.edu.ifsc.neabiAndroid.data.local.NeabicanDatabase
import br.edu.ifsc.neabiAndroid.domain.repository.InitializationRepository

class NeabiCanApplication: Application() {
    val neabicanDatabase: NeabicanDatabase by lazy{
        NeabicanDatabase.getInstance(this)
    }

    val initialRepository:InitializationRepository by lazy {
        InitializationRepository(neabicanDatabase)
    }
}