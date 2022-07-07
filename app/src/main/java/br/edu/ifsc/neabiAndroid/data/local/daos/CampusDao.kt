package br.edu.ifsc.neabiAndroid.data.local.daos

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import br.edu.ifsc.neabiAndroid.data.local.entities.CampusEntity

@Dao
interface CampusDao {

    @Query("SELECT * FROM campus")
    fun getAllCampus(): LiveData<List<CampusEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAllCampus(campus: List<CampusEntity>)
}