package br.edu.ifsc.aquilombar.data.local.daos

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query
import br.edu.ifsc.aquilombar.data.local.entities.StudentAssistanceEntity

@Dao
interface StudentAssistanceDao {

    @Query("SELECT * FROM studentAssistance")
    fun getAllStudentAid(): LiveData<List<StudentAssistanceEntity>>

    @Query("DELETE FROM studentAssistance")
    suspend fun clearTable()

    @Insert(onConflict = REPLACE)
    suspend fun insertAllStudentAid(actions: List<StudentAssistanceEntity>)
}