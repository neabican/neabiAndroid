package br.edu.ifsc.neabiAndroid.ui.home

import androidx.lifecycle.ViewModel
import br.edu.ifsc.neabiAndroid.domain.model.Campus


class HomeViewModel: ViewModel() {

    fun getCampusList(): List<Campus> {
        return emptyList()
    }
}