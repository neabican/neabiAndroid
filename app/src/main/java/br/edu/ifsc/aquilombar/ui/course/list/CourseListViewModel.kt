package br.edu.ifsc.aquilombar.ui.course.list

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.asLiveData
import br.edu.ifsc.aquilombar.domain.model.Course
import br.edu.ifsc.aquilombar.domain.repository.CourseRepository
import java.lang.IllegalArgumentException

class CourseListViewModel(private val rep: CourseRepository): ViewModel() {

    private val _filter = MutableLiveData("")
    val filter: LiveData<String>
        get() = _filter

    private val _courses: LiveData<List<Course>> = rep.getAllCourse().asLiveData()
    val courses: LiveData<List<Course>>
        get(){
            return if(_filter.value==""){
                _courses
            }else{
                val filtredList = _courses.value?.filter {
                    it.name.contains(_filter.value ?:"", true)
                }
                return MutableLiveData(filtredList)
            }
        }


    fun updateFilter(search: String){
        _filter.value = search
    }

}

class CourseVMFactory(private val repository: CourseRepository) : ViewModelProvider.Factory{
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(CourseListViewModel::class.java))
            return CourseListViewModel(repository) as T
        throw IllegalArgumentException("Unknown ViewModel Class")
    }
}