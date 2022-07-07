package br.edu.ifsc.neabiAndroid.data.local.daos

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query
import br.edu.ifsc.neabiAndroid.data.local.entities.CoursesEntity

@Dao
interface CoursesDao {

    @Query("SELECT * FROM courses")
    fun getAllCourses(): LiveData<List<CoursesEntity>>

    @Insert(onConflict = REPLACE)
    fun insertAllCourses(courses: List<CoursesEntity>)
}