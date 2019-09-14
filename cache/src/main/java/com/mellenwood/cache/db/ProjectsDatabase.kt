package com.mellenwood.cache.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.mellenwood.cache.model.CachedProject
import javax.inject.Inject

@Database(entities = arrayOf(CachedProject::class), version = 1)
abstract class ProjectsDatabase @Inject constructor(): RoomDatabase() {

    companion object {
        private var INSTANCE: ProjectsDatabase? = null
        private val lock = Any()

        fun getInstance(context: Context): ProjectsDatabase {
            if (INSTANCE == null) {
                synchronized(lock) {
                    if (INSTANCE == null) {
                        INSTANCE = Room.databaseBuilder(
                            context,
                            ProjectsDatabase::class.java, "projects.db"
                        ).build()
                    }
                    return INSTANCE as ProjectsDatabase
                }
            }
            return INSTANCE as ProjectsDatabase
        }
    }
}