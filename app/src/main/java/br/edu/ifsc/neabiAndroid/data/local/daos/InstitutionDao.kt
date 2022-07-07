package br.edu.ifsc.neabiAndroid.data.local.daos

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import br.edu.ifsc.neabiAndroid.data.local.entities.InstitutionEntity

@Dao
interface InstitutionDao {

    @Query("SELECT * FROM institution")
    fun getAllInstitution(): LiveData<List<InstitutionEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAllInstitutions(institutions: List<InstitutionEntity>)
}