package br.edu.ifsc.aquilombar.data.local.daos

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import br.edu.ifsc.aquilombar.data.local.entities.CourseEntity


@Dao
interface CourseDao {

    @Query("SELECT * FROM course")
    suspend fun getAllCourse(): List<CourseEntity>

    @Query("SELECT * FROM course WHERE pk=:pk")
    suspend fun getCourse(pk:Int): CourseEntity

    @Query("DELETE FROM course")
    suspend fun clearTable()

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAllCourse(courses: List<CourseEntity>)
}