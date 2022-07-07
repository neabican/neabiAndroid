package br.edu.ifsc.neabiAndroid.data.local.daos

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query
import br.edu.ifsc.neabiAndroid.data.local.entities.ProgramEntity

@Dao
interface ProgramDao {

    @Query("SELECT * FROM program")
    fun getAllProgram(): LiveData<List<ProgramEntity>>

    @Insert(onConflict = REPLACE)
    fun insertAllProgram(programs: List<ProgramEntity>)
}