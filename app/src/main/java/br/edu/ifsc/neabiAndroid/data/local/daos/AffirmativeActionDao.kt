package br.edu.ifsc.neabiAndroid.data.local.daos

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query
import br.edu.ifsc.neabiAndroid.data.local.entities.AffirmativeActionEntity

@Dao
interface AffirmativeActionDao {

    @Query("SELECT * FROM affirmativeAction")
    fun getAllAffirmativeActions(): LiveData<List<AffirmativeActionEntity>>

    @Query("DELETE FROM affirmativeAction")
    suspend fun clearTable()

    @Insert(onConflict = REPLACE)
    suspend fun insertAllAffitmativeActions(actions: List<AffirmativeActionEntity>)
}