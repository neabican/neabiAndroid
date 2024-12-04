package br.edu.ifsc.aquilombar.domain.repository

import br.edu.ifsc.aquilombar.data.local.daos.CourseDao
import br.edu.ifsc.aquilombar.domain.model.Course
import br.edu.ifsc.aquilombar.util.toDomain
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class CourseRepository (private val dao: CourseDao){

    fun getAllCourse(): Flow<List<Course>> {
       return flow {
           val courses = dao.getAllCourse().toDomain()
           emit(courses)
       }
    }

    suspend fun getCourse(pk: Int): Course{
        return dao.getCourse(pk).toDomain()
    }
}