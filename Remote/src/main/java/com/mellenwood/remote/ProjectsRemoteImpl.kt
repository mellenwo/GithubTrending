package com.mellenwood.remote

import com.mellenwood.data.model.ProjectEntity
import com.mellenwood.data.repository.ProjectsRemote
import com.mellenwood.remote.mapper.ProjectsResponseModelMapper
import com.mellenwood.remote.service.GithubTrendingService
import io.reactivex.Completable
import io.reactivex.Observable
import javax.inject.Inject

class ProjectsRemoteImpl @Inject constructor(
            private val service: GithubTrendingService,
            private val mapper: ProjectsResponseModelMapper)
    : ProjectsRemote {

    override fun getProjects(): Observable<List<ProjectEntity>> {
        return service.searchRepositories("language:kotlin", "stars", "desc")
            .map {
                it.items.map { mapper.mapFromModel(it) }
            }
    }

}