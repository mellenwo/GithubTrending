package com.mellenwood.cache.model

import androidx.room.Entity
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import com.mellenwood.cache.db.ConfigConstants

@Entity(tableName = ConfigConstants.TABLE_NAME)
class Config(val lastCacheTime: Long)