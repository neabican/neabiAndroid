package br.edu.ifsc.aquilombar.domain.model

data class Campus(
    val pk: Int,
    val name: String,
    val link: String,
    val institution: Institution,
    val address: Address,
    val description: String,
    val courses: List<Courses> = listOf(),
    val image: List<Image> = listOf(),
    val program: List<Program> = listOf(),
    val project: List<Project> = listOf(),
    val studentAssistence: List<StudentAssistence> = listOf(),
)
