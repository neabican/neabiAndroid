package br.edu.ifsc.neabiAndroid.data.domain

data class Campus(
    val pk: Int,
    val name: String,
    val institution: Institution,
    val address: Address,
    val courses: List<Courses>,
    val program: List<Program>,
    val project: List<Project>,
    val affirmativeAction: List<AffirmativeAction>,
)