package br.edu.ifsc.neabiAndroid.ui.course

import android.util.Log
import androidx.lifecycle.*
import br.edu.ifsc.neabiAndroid.domain.model.Campus
import br.edu.ifsc.neabiAndroid.domain.model.Course
import br.edu.ifsc.neabiAndroid.domain.model.Courses
import br.edu.ifsc.neabiAndroid.domain.repository.CoursesRepository
import kotlinx.coroutines.launch
import java.lang.IllegalArgumentException

class CoursesViewModel(val rep: CoursesRepository): ViewModel() {

    private var _courses: LiveData<Courses> = MutableLiveData()
    val courses: LiveData<Courses>
        get() = _courses

    fun setCourse(campusPk: Int){
        if(campusPk==-1){
            _courses = MutableLiveData(Courses(-1,"","Não foi possivel encontar o curso", Course(0,"",""),1))
        }
        viewModelScope.launch {
            _courses = rep.getCourseUnion(campusPk)
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
