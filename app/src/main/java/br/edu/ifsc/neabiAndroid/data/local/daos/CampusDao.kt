package br.edu.ifsc.neabiAndroid.data.local.daos

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction
import br.edu.ifsc.neabiAndroid.data.local.entities.AllCampusInfo
import br.edu.ifsc.neabiAndroid.data.local.entities.CampusEntity
import br.edu.ifsc.neabiAndroid.data.local.entities.HomeEntity

@Dao
interface CampusDao {

    @Query("SELECT * FROM campus")
    suspend fun getAllCampus(): List<CampusEntity>

    @Query("SELECT * FROM campus WHERE pk IN (:list)")
    suspend fun getCampusByPk(list: List<Int>): List<CampusEntity>

    @Query("DELETE FROM campus")
    suspend fun clearTable()

    @Query("SELECT * FROM campus")
    suspend fun getHomeInfo(): List<HomeEntity>

    @Transaction
    @Query("SELECT * FROM campus WHERE pk=:campusPk")
    fun getCampus(campusPk: Int): LiveData<AllCampusInfo>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAllCampus(campus: List<CampusEntity>)
}