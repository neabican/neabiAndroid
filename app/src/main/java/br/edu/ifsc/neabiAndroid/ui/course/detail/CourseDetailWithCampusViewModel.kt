package br.edu.ifsc.neabiAndroid.ui.course.detail

import androidx.lifecycle.*
import br.edu.ifsc.neabiAndroid.domain.model.Campus
import br.edu.ifsc.neabiAndroid.domain.model.Course
import br.edu.ifsc.neabiAndroid.domain.repository.CampusRepository
import br.edu.ifsc.neabiAndroid.domain.repository.CourseRepository
import br.edu.ifsc.neabiAndroid.domain.repository.CoursesRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import java.lang.IllegalArgumentException

class CourseCampusViewModel(
    private val courseRep: CourseRepository,
    private val coursesRep: CoursesRepository,
    private val campusRep: CampusRepository
): ViewModel() {

    private var _uiState = MutableStateFlow(UiStateCourseDetail())
    val uiState: StateFlow<UiStateCourseDetail>
        get() = _uiState.asStateFlow()


    fun updateUiState(pk: Int){
        viewModelScope.launch {

            // Search for the Course and campus
            val course = courseRep.getCourse(pk)
            _uiState.update {
                it.copy(
                    course = course
                )
            }
            val campusPkList = coursesRep.getCampusPkByCampusPk(course.pk)
            val campusList = campusRep.getCampusByListOfPk(campusPkList)
            _uiState.update {
                it.copy(
                    campus = campusList
                )
            }
        }
    }

    data class UiStateCourseDetail(
        val course: Course? = null,
        val campus: List<Campus> = listOf()
    )
}

class CourseCampusVMFactory(
    private val courseRep: CourseRepository,
    private val coursesRep: CoursesRepository,
    private val campusRep: CampusRepository
) : ViewModelProvider.Factory{
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(CourseCampusViewModel::class.java))
            return CourseCampusViewModel(courseRep, coursesRep, campusRep) as T
        throw IllegalArgumentException("Unknown ViewModel Class")
    }
}