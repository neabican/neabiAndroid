package br.edu.ifsc.neabiAndroid.ui.course.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import br.edu.ifsc.neabiAndroid.domain.model.Campus
import br.edu.ifsc.neabiAndroid.domain.model.Course
import br.edu.ifsc.neabiAndroid.domain.repository.CourseRepository
import java.lang.IllegalArgumentException

class CourseCampusViewModel(val rep: CourseRepository): ViewModel() {

    private var _course: LiveData<Course> = MutableLiveData()
    val course: LiveData<Course>
        get() = _course


    private var _campus: LiveData<List<Campus>> = MutableLiveData()
    val campus: LiveData<List<Campus>>
        get() = _campus
}

class CourseCampusVMFactory(private val repository: CourseRepository) : ViewModelProvider.Factory{
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(CourseCampusViewModel::class.java))
            return CourseCampusViewModel(repository) as T
        throw IllegalArgumentException("Unknown ViewModel Class")
    }
}