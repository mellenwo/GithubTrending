package com.mellenwood.domain.interactor.bookmarked

import com.mellenwood.domain.executor.PostExecutionThread
import com.mellenwood.domain.interactor.ObservableUseCase
import com.mellenwood.domain.model.Project
import com.mellenwood.domain.repository.ProjectsRepository
import io.reactivex.Observable
import javax.inject.Inject

open class GetBookmarkedProjects @Inject constructor(
        private val projectsRepository: ProjectsRepository,
        postExecutionThread: PostExecutionThread)
    : ObservableUseCase<List<Project>, Nothing?>(postExecutionThread){


    public override fun buildUseCaseObservable(params: Nothing?): Observable<List<Project>> {
        return projectsRepository.getBookmarkedProjects()
    }


}