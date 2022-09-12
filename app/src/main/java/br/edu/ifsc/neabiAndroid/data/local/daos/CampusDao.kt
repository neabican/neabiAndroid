package br.edu.ifsc.neabiAndroid.data.local.daos

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import br.edu.ifsc.neabiAndroid.data.local.entities.AllCampusInfo
import br.edu.ifsc.neabiAndroid.data.local.entities.CampusEntity
import br.edu.ifsc.neabiAndroid.data.local.entities.HomeEntity

@Dao
interface CampusDao {

    @Query("SELECT * FROM campus")
    fun getAllCampus(): List<CampusEntity>

    @Query("SELECT * FROM campus")
    fun getHomeInfo(): LiveData<List<HomeEntity>>

    @Query("SELECT * FROM campus WHERE pk=:campusPk")
    fun getCampus(campusPk: Int): LiveData<AllCampusInfo>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAllCampus(campus: List<CampusEntity>)
}