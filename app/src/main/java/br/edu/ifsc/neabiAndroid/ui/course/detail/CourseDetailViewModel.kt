package br.edu.ifsc.neabiAndroid.ui.course.detail

import androidx.lifecycle.*
import br.edu.ifsc.neabiAndroid.domain.model.Courses
import br.edu.ifsc.neabiAndroid.domain.repository.CoursesRepository
import br.edu.ifsc.neabiAndroid.util.EmptyClass
import kotlinx.coroutines.launch
import java.lang.IllegalArgumentException

class CoursesViewModel(val rep: CoursesRepository): ViewModel() {

    private var _courses: LiveData<Courses> = MutableLiveData()
    val courses: LiveData<Courses>
        get() = _courses

    fun setCourse(coursePk: Int){
        if(coursePk==-1){
            _courses = MutableLiveData(EmptyClass.emptyCourse)
        }
        viewModelScope.launch {
            _courses = rep.getCourseUnion(coursePk)
        }
    }
}


class CoursesVMFactory(private val repository: CoursesRepository) : ViewModelProvider.Factory{
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(CoursesViewModel::class.java))
            return CoursesViewModel(repository) as T
        throw IllegalArgumentException("Unknown ViewModel Class")
    }
}
