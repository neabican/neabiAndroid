package br.edu.ifsc.neabiAndroid.data.local.daos

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query
import br.edu.ifsc.neabiAndroid.data.local.entities.AddressEntity

@Dao
interface AddressDao {

    @Query("SELECT * FROM address")
    fun getAllAddress(): LiveData<List<AddressEntity>>

    @Insert(onConflict = REPLACE)
    fun insertAllAddress(address: List<AddressEntity>)
}