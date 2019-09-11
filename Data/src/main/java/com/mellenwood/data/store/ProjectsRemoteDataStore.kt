package com.mellenwood.data.store

import com.mellenwood.data.model.ProjectEntity
import com.mellenwood.data.repository.ProjectsDataStore
import com.mellenwood.data.repository.ProjectsRemote
import io.reactivex.Completable
import io.reactivex.Observable
import javax.inject.Inject

open class ProjectsRemoteDataStore @Inject constructor(
        private val projectsRemote: ProjectsRemote
): ProjectsDataStore {

    override fun clearProjects(): Completable {
        throw UnsupportedOperationException("Clearing projects isn't supported here.")
    }

    override fun saveProjects(projects: List<ProjectEntity>): Completable {
        throw UnsupportedOperationException("Saving projects isn't supported here.")
    }

    override fun getProjects(): Observable<List<ProjectEntity>> {
        return projectsRemote.getProjects()
    }

    override fun getBookmarkedProjects(): Observable<List<ProjectEntity>> {
        throw UnsupportedOperationException("Getting bookmarked projects isn't supported here")
    }

    override fun setProjectAsBookmarked(projectId: String): Completable {
        throw UnsupportedOperationException("Setting project as bookmarked isn't supported here")
    }

    override fun setProjectAsNotBookmarked(projectId: String): Completable {
        throw UnsupportedOperationException("Setting project as unbookmarked isn't supported here")
    }
}
