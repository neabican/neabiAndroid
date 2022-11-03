package br.edu.ifsc.neabiAndroid.util

import br.edu.ifsc.neabiAndroid.domain.model.Address
import br.edu.ifsc.neabiAndroid.domain.model.Campus
import br.edu.ifsc.neabiAndroid.domain.model.Institution

object EmptyClass {

    val emptyCampus = Campus(
        0,
        "",
        "",
        "www.google.com",
        Institution(
            0,
            "",
            "",
            listOf()
        ),
        Address(
            0,
            "",
            "",
            "",
            "",
            "",
            "-26.1833444",
            "-50.3670326"
        )
    )
}