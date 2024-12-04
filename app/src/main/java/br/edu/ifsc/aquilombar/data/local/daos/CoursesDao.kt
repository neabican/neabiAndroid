package br.edu.ifsc.aquilombar.data.local.daos

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query
import br.edu.ifsc.aquilombar.data.local.entities.CourseUnion
import br.edu.ifsc.aquilombar.data.local.entities.CoursesEntity

@Dao
interface CoursesDao {

    @Query("SELECT * FROM courses")
    fun getAllCourses(): LiveData<List<CoursesEntity>>

    @Query("SELECT campusPk FROM courses WHERE coursePk=:coursePk")
    suspend fun getCampusIdByCoursePk(coursePk: Int): List<Int>

    @Query("SELECT * FROM courses WHERE pk=:coursePk")
    fun getCourseUnion(coursePk:Int): LiveData<CourseUnion>

    @Query("DELETE FROM courses")
    suspend fun clearTable()

    @Insert(onConflict = REPLACE)
    suspend fun insertAllCourses(courses: List<CoursesEntity>)
}