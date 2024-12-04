package br.edu.ifsc.aquilombar.data.local.daos

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import br.edu.ifsc.aquilombar.data.local.entities.DBVersionEntity

@Dao
interface DBVersionDao {

    @Query("SELECT * FROM db_version")
    suspend fun getDatabaseVersion(): DBVersionEntity

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertDatabaseVersion(databaseVersion: DBVersionEntity)

}