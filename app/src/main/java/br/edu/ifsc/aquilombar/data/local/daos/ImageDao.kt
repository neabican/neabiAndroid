package br.edu.ifsc.aquilombar.data.local.daos

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query
import br.edu.ifsc.aquilombar.data.local.entities.ImageEntity

@Dao
interface ImageDao {

    @Query("SELECT * FROM image")
    fun getAllImage(): LiveData<List<ImageEntity>>

    @Query("DELETE FROM image")
    suspend fun clearTable()

    @Insert(onConflict = REPLACE)
    suspend fun insertAllImages(images: List<ImageEntity>)
}