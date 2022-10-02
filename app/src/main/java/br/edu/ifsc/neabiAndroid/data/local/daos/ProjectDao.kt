package br.edu.ifsc.neabiAndroid.data.local.daos

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query
import br.edu.ifsc.neabiAndroid.data.local.entities.ProjectEntity

@Dao
interface ProjectDao {

    @Query("SELECT * FROM project")
    fun getAllProjects(): LiveData<List<ProjectEntity>>

    @Query("DELETE FROM project")
    suspend fun clearTable()

    @Insert(onConflict = REPLACE)
    suspend fun insertAllProjects(projects: List<ProjectEntity>)
}