package br.edu.ifsc.aquilombar.data.local.daos

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query
import br.edu.ifsc.aquilombar.data.local.entities.AddressEntity

@Dao
interface AddressDao {

    @Query("SELECT * FROM address")
    fun getAllAddress(): LiveData<List<AddressEntity>>

    @Query("DELETE FROM address")
    suspend fun clearTable()

    @Insert(onConflict = REPLACE)
    suspend fun insertAllAddress(address: List<AddressEntity>)
}