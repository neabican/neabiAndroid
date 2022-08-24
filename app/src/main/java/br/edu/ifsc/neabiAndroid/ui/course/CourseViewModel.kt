package br.edu.ifsc.neabiAndroid.ui.course

import br.edu.ifsc.neabiAndroid.domain.model.Course

class CourseViewModel(course: Course) {
    val name = course.name
    val description = course.description
}
