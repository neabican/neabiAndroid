package br.edu.ifsc.neabiAndroid.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import br.edu.ifsc.neabiAndroid.data.local.daos.*
import br.edu.ifsc.neabiAndroid.data.local.entities.*


@Database(
    entities = [DBVersionEntity::class, InstitutionEntity::class, AddressEntity::class,
                CourseEntity::class, CampusEntity::class, CoursesEntity::class,
                ProgramEntity::class, ProjectEntity::class, AffirmativeActionEntity::class],
    version = 1,
    exportSchema = false
)
abstract class NeabicanDatabase: RoomDatabase() {

    abstract fun DBVersionDao(): DBVersionDao
    abstract fun institutionDao(): InstitutionDao
    abstract fun addressDao(): AddressDao
    abstract fun courseDao(): CourseDao
    abstract fun campusDao(): CampusDao
    abstract fun coursesDao(): CoursesDao
    abstract fun programDao(): ProgramDao
    abstract fun project(): ProjectDao
    abstract fun affirmaticeActionDao(): AffirmativeActionDao

    companion object{

        @Volatile var INSTANCE: NeabicanDatabase? = null

        fun getInstance(context: Context): NeabicanDatabase{
            return INSTANCE ?: synchronized(this){
                val instance = Room.databaseBuilder(
                    context,
                    NeabicanDatabase::class.java,
                    "neabican_database"
                )
                    .fallbackToDestructiveMigration()
                    .build()
                INSTANCE = instance
                return instance
            }
        }
    }
}