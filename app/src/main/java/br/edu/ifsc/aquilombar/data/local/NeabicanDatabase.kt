package br.edu.ifsc.aquilombar.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import br.edu.ifsc.aquilombar.data.local.daos.*
import br.edu.ifsc.aquilombar.data.local.entities.*


@Database(
    entities = [DBVersionEntity::class, InstitutionEntity::class, AddressEntity::class,
                CourseEntity::class, CampusEntity::class, CoursesEntity::class,
                ProgramEntity::class, ImageEntity::class ,ProjectEntity::class, StudentAssistanceEntity::class],
    version = 4,
    exportSchema = false
)
abstract class NeabicanDatabase: RoomDatabase() {

    abstract fun DBVersionDao(): DBVersionDao
    abstract fun institutionDao(): InstitutionDao
    abstract fun addressDao(): AddressDao
    abstract fun courseDao(): CourseDao
    abstract fun campusDao(): CampusDao
    abstract fun coursesDao(): CoursesDao
    abstract fun imageDao(): ImageDao
    abstract fun programDao(): ProgramDao
    abstract fun projectDao(): ProjectDao
    abstract fun studentAssistanceDao(): StudentAssistanceDao

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