package br.edu.ifsc.neabiAndroid.domain.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import br.edu.ifsc.neabiAndroid.data.local.daos.CoursesDao
import br.edu.ifsc.neabiAndroid.domain.model.Courses
import br.edu.ifsc.neabiAndroid.util.toDomain
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class CoursesRepository(private val dao: CoursesDao){

    suspend fun getCampusPkByCampusPk(pk: Int): List<Int>{
        return dao.getCampusIdByCoursePk(pk)
    }

    suspend fun getCourseUnion(coursesPk: Int): LiveData<Courses>{
        var course: LiveData<Courses>
        withContext(Dispatchers.Default){
            course = Transformations.map(dao.getCourseUnion(coursesPk)){
                Courses(
                    pk = it.coursesEntity.pk,
                    link = it.coursesEntity.link,
                    addition_info = it.coursesEntity.addition_info,
                    campus = it.coursesEntity.campusPk,
                    course = it.courseEntity.toDomain(),
                    vacancies = it.coursesEntity.vacancies
                )
            }
        }
        return course
    }
}