package br.edu.ifsc.neabiAndroid.data.local.daos

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import br.edu.ifsc.neabiAndroid.data.local.entities.CourseEntity


@Dao
interface CourseDao {

    @Query("SELECT * FROM course")
    fun getAllCourse(): LiveData<List<CourseEntity>>

    @Query("DELETE FROM course")
    suspend fun clearTable()

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAllCourse(courses: List<CourseEntity>)
}