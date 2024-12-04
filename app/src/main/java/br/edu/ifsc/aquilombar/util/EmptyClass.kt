package br.edu.ifsc.aquilombar.util

import br.edu.ifsc.aquilombar.domain.model.*

object EmptyClass {

    val emptyInstitution = Institution(
        pk = -1,
        name = "",
        initials = "",
        listOf()
    )

    val emptyAddress = Address(
        pk = -1,
        city = "",
        state = "",
        number = "",
        public_place = "",
        zip_code = "",
        latitude = "",
        longitude = ""
    )

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