package br.edu.ifsc.neabiAndroid.util

import br.edu.ifsc.neabiAndroid.domain.model.*

object EmptyClass {

    val emptyCourse = Courses(
        -1,
        "",
        "Não foi possivel encontar o curso",
        1,
        Course(
            1,
            "",
            ""
        ),
        1
    )

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
        ),
        ""
    )
}