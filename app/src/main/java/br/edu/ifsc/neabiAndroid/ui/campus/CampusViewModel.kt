package br.edu.ifsc.neabiAndroid.ui.campus

import br.edu.ifsc.neabiAndroid.domain.model.Campus2

class CampusViewModel(val campus: Campus2) {
    /* TODO */

    fun getName() : String {
        return campus.name
    }

    fun getImage() : String {
        return campus.image
    }
}
