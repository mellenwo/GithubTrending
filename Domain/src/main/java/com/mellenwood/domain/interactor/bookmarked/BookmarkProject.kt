package com.mellenwood.domain.interactor.bookmarked

import com.mellenwood.domain.executor.PostExecutionThread
import com.mellenwood.domain.interactor.CompletableUseCase
import com.mellenwood.domain.repository.ProjectsRepository
import io.reactivex.Completable
import java.lang.IllegalArgumentException
import java.lang.IllegalStateException
import javax.inject.Inject

open class BookmarkProject @Inject constructor(
        private val projectsRepository: ProjectsRepository,
        postExecutionThread: PostExecutionThread)
    : CompletableUseCase<BookmarkProject.Params>(postExecutionThread){

    public override fun buildUseCaseCompletable(params: Params?): Completable {
        if (params == null) throw IllegalArgumentException("Params can't be null!")
        return projectsRepository.bookmarkProject(params.projectId)
    }


    data class Params constructor(val projectId: String) {
        companion object {
            fun forProject(projectId: String) : Params {
                return Params(projectId)
            }
        }
    }

}