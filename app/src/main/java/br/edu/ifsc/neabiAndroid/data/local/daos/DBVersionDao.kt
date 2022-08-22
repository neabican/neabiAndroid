package br.edu.ifsc.neabiAndroid.data.local.daos

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import br.edu.ifsc.neabiAndroid.data.local.entities.DBVersionEntity

@Dao
interface DBVersionDao {

    @Query("SELECT * FROM db_version limit 1")
    fun getDatabaseVersion(): DBVersionEntity

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertDatabaseVersion(databaseVersion: DBVersionEntity)

}