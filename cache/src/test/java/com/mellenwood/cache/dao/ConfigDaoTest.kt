package com.mellenwood.cache.dao

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import com.mellenwood.cache.db.ProjectsDatabase
import com.mellenwood.cache.test.factory.ConfigDataFactory
import org.junit.After
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner

@RunWith(RobolectricTestRunner::class)
class ConfigDaoTest {

    @Rule
    @JvmField var instantTaskExecutorRule = InstantTaskExecutorRule()

    private val database = Room.inMemoryDatabaseBuilder(
        ApplicationProvider.getApplicationContext(),
        ProjectsDatabase::class.java)
        .allowMainThreadQueries()
        .build()

    @After
    fun closeDb() {
        database.close()
    }

    @Test
    fun saveConfigurationSavesData() {
        val config = ConfigDataFactory.makeCachedConfig()
        database.configDao().insertConfig(config)

        val testObserver = database.configDao().getConfig().test()
        testObserver.assertValue(config)
    }

}