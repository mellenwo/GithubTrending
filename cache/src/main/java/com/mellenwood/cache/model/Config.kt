package com.mellenwood.cache.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.mellenwood.cache.db.ConfigConstants

@Entity(tableName = ConfigConstants.TABLE_NAME)
data class Config(
    @PrimaryKey
    var lastCacheTime: Long)