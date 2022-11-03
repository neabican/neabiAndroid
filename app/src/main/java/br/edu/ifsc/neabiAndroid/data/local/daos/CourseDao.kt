package br.edu.ifsc.neabiAndroid.data.local.daos

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import br.edu.ifsc.neabiAndroid.data.local.entities.CourseEntity
import kotlinx.coroutines.flow.Flow


@Dao
interface CourseDao {

    @Query("SELECT * FROM course")
    suspend fun getAllCourse(): List<CourseEntity>

    @Query("DELETE FROM course")
    suspend fun clearTable()

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAllCourse(courses: List<CourseEntity>)
}