package br.edu.ifsc.neabiAndroid.domain.model

data class Campus(
    val pk: Int,
    val name: String,
    val image: String,
    val link: String,
    val institution: Institution,
    val address: Address,
    val description: String,
    val courses: List<Courses> = listOf(),
    val program: List<Program> = listOf(),
    val project: List<Project> = listOf(),
    val studentAssistence: List<StudentAssistence> = listOf(),
)
