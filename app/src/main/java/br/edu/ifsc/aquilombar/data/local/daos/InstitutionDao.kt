package br.edu.ifsc.aquilombar.data.local.daos

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import br.edu.ifsc.aquilombar.data.local.entities.InstitutionEntity

@Dao
interface InstitutionDao {

    @Query("SELECT * FROM institution")
    fun getAllInstitution(): LiveData<List<InstitutionEntity>>

    @Query("DELETE FROM institution")
    suspend fun clearTable()

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAllInstitutions(institutions: List<InstitutionEntity>)
}