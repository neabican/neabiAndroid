package br.edu.ifsc.neabiAndroid.domain.model

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