package com.mellenwood.data.store

import com.mellenwood.data.model.ProjectEntity
import com.mellenwood.data.repository.ProjectsCache
import com.mellenwood.data.repository.ProjectsDataStore
import io.reactivex.Completable
import io.reactivex.Observable
import javax.inject.Inject

open class ProjectsCacheDataStore @Inject constructor(
        private val projectsCache: ProjectsCache
): ProjectsDataStore {

    override fun clearProjects(): Completable {
        return projectsCache.clearProjects()
    }

    override fun saveProjects(projects: List<ProjectEntity>): Completable {
        return projectsCache.saveProjects(projects)
            .andThen(projectsCache.setLastCacheTime(System.currentTimeMillis()))
    }

    override fun getProjects(): Observable<List<ProjectEntity>> {
        return projectsCache.getProjects()
    }

    override fun getBookmarkedProjects(): Observable<List<ProjectEntity>> {
        return projectsCache.getBookmarkedProjects()
    }

    override fun setProjectAsBookmarked(projectId: String): Completable {
        return projectsCache.setProjectAsBookmarked(projectId)
    }

    override fun setProjectAsNotBookmarked(projectId: String): Completable {
        return projectsCache.setProjectAsNotBookmarked(projectId)
    }
}