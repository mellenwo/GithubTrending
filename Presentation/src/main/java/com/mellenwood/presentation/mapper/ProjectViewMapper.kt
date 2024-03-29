package com.mellenwood.presentation.mapper

import com.mellenwood.domain.model.Project
import com.mellenwood.presentation.model.ProjectView
import javax.inject.Inject

open class ProjectViewMapper @Inject constructor(): Mapper<ProjectView, Project> {

    override fun mapToView(type: Project): ProjectView {
        return ProjectView(type.id, type.name, type.fullName,
            type.starCount, type.dateCreated, type.ownerName,
            type.ownerAvatar, type.isBookmarked)
    }


}