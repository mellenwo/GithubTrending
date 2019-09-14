package com.mellenwood.cache.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.mellenwood.cache.db.ProjectConstants

@Entity(tableName = ProjectConstants.TABLE_NAME)
class CachedProject (
        @PrimaryKey
        var id: String,
        var name: String,
        var fullName: String,
        var starCount: String,
        var dateCreated: String,
        var ownerName: String,
        var ownerAvatar: String,
        var isBookmarked: Boolean
)