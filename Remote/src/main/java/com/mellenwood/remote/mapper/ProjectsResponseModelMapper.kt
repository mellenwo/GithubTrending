package com.mellenwood.remote.mapper

import com.mellenwood.data.model.ProjectEntity
import com.mellenwood.remote.model.ProjectModel

open class ProjectsResponseModelMapper: ModelMapper<ProjectModel, ProjectEntity> {

    override fun mapFromModel(model: ProjectModel): ProjectEntity {
        return ProjectEntity(model.id, model.name, model.fullName,
            model.starCount.toString(), model.dateCreated, model.owner.ownerName,
            model.owner.ownerAvatar)
    }


}