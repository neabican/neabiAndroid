package br.edu.ifsc.neabiAndroid.data.local.daos

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query
import br.edu.ifsc.neabiAndroid.data.local.entities.StudentAidEntity

@Dao
interface StudentAidDao {

    @Query("SELECT * FROM studentAid")
    fun getAllStudentAid(): LiveData<List<StudentAidEntity>>

    @Query("DELETE FROM studentAid")
    suspend fun clearTable()

    @Insert(onConflict = REPLACE)
    suspend fun insertAllStudentAid(actions: List<StudentAidEntity>)
}