package br.edu.ifsc.neabiAndroid.data.local.daos

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query
import br.edu.ifsc.neabiAndroid.data.local.entities.CourseUnion
import br.edu.ifsc.neabiAndroid.data.local.entities.CoursesEntity

@Dao
interface CoursesDao {

    @Query("SELECT * FROM courses")
    fun getAllCourses(): LiveData<List<CoursesEntity>>

    @Query("SELECT * FROM courses WHERE pk=:pk")
    fun getCourseUnion(pk:Int): LiveData<CourseUnion>

    @Query("DELETE FROM courses")
    suspend fun clearTable()

    @Insert(onConflict = REPLACE)
    suspend fun insertAllCourses(courses: List<CoursesEntity>)
}