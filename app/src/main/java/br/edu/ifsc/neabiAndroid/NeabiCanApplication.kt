package br.edu.ifsc.neabiAndroid

import android.app.Application
import br.edu.ifsc.neabiAndroid.data.local.NeabicanDatabase

class NeabiCanApplication: Application() {
    val neabicanDatabase: NeabicanDatabase by lazy{
        NeabicanDatabase.getInstance(this)
    }
}