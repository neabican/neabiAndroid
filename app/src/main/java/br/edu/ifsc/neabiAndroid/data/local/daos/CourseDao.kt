package br.edu.ifsc.neabiAndroid.data.local.daos

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import br.edu.ifsc.neabiAndroid.data.local.entities.CourseEntity


@Dao
interface CourseDao {

    @Query("SELECT * FROM courseentity")
    fun getAll(): LiveData<List<CourseEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAllCourses(courses: List<CourseEntity>)
}