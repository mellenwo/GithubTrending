package com.mellenwood.data

import com.mellenwood.data.mapper.ProjectMapper
import com.mellenwood.data.model.ProjectEntity
import com.mellenwood.data.repository.ProjectsCache
import com.mellenwood.data.repository.ProjectsDataStore
import com.mellenwood.data.store.ProjectsDataStoreFactory
import com.mellenwood.data.test.factory.DataFactory
import com.mellenwood.data.test.factory.ProjectFactory
import com.mellenwood.domain.model.Project
import com.nhaarman.mockitokotlin2.any
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.whenever
import io.reactivex.Completable
import io.reactivex.Observable
import io.reactivex.Single
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class ProjectsDataRepositoryTest {

    private val mapper = mock<ProjectMapper>()
    private val factory = mock<ProjectsDataStoreFactory>()
    private val store = mock<ProjectsDataStore>()
    private val cache = mock<ProjectsCache>()
    private val repository = ProjectsDataRepository(mapper, cache, factory)


    @Before
    fun setup() {
        stubFactoryGetDataStore()
        stubFactoryGetCachedDataStore()
        stubIsCacheExpired(Single.just(false))
        stubAreProjectsCached((Single.just(false)))
        stubSaveProjects(Completable.complete())
    }

    @Test
    fun getProjectsCompletes() {
        stubGetProjects(Observable.just(listOf(ProjectFactory.makeProjectEntity())))
        stubMapper(ProjectFactory.makeProject(), any())

        val testObserver = repository.getProjects().test()
        testObserver.assertComplete()
    }

    @Test
    fun getBookmarkedProjectsCompletes() {
        stubGetBookmarkedProjects(Observable.just(listOf(ProjectFactory.makeProjectEntity())))
        stubMapper(ProjectFactory.makeProject(), any())

        val testObserver = repository.getBookmarkedProjects().test()
        testObserver.assertComplete()
    }

    @Test
    fun getProjectsReturnsData() {
        val projectEntity = ProjectFactory.makeProjectEntity()
        val project = ProjectFactory.makeProject()

        stubGetProjects(Observable.just(listOf(projectEntity)))
        stubMapper(project, projectEntity)

        val testObserver = repository.getProjects().test()
        testObserver.assertValue(listOf(project))
    }

    @Test
    fun getBookmarkedProjectsReturnsData() {
        val projectEntity = ProjectFactory.makeProjectEntity()
        val project = ProjectFactory.makeProject()

        stubGetBookmarkedProjects(Observable.just(listOf(projectEntity)))
        stubMapper(project, projectEntity)

        val testObserver = repository.getBookmarkedProjects().test()
        testObserver.assertValue(listOf(project))
    }

    @Test
    fun bookmarkProjectsCompletes() {
        stubBookmarkProjects(Completable.complete())

        val testObserver = repository.bookmarkProject(DataFactory.randomString()).test()
        testObserver.assertComplete()

    }

    @Test
    fun unbookmarkProjectsCompletes() {
        stubUnbookmarkProjects(Completable.complete())

        val testObserver = repository.unbookmarkProject(DataFactory.randomString()).test()
        testObserver.assertComplete()

    }

    private fun stubUnbookmarkProjects(completable: Completable) {
        whenever(store.setProjectAsNotBookmarked(any()))
            .thenReturn(completable)
    }

    private fun stubBookmarkProjects(completable: Completable) {
        whenever(store.setProjectAsBookmarked(any()))
            .thenReturn(completable)
    }

    private fun stubIsCacheExpired(single: Single<Boolean>) {
        whenever(cache.isProjectsCacheExpired())
            .thenReturn(single)
    }

    private fun stubAreProjectsCached(single: Single<Boolean>) {
        whenever(cache.areProjectsCached())
            .thenReturn(single)
    }

    private fun stubFactoryGetCachedDataStore() {
        whenever(factory.getCacheDataStore())
            .thenReturn(store)
    }

    private fun stubSaveProjects(completable: Completable) {
        whenever(store.saveProjects(any()))
            .thenReturn(completable)
    }

    private fun stubMapper(model: Project, entity: ProjectEntity){
        whenever(mapper.mapFromEntity(entity))
            .thenReturn(model)
    }

    private fun stubGetProjects(observable: Observable<List<ProjectEntity>>) {
        whenever(store.getProjects())
            .thenReturn(observable)
    }

    private fun stubGetBookmarkedProjects(observable: Observable<List<ProjectEntity>>) {
        whenever(store.getBookmarkedProjects())
            .thenReturn(observable)
    }

    private fun stubFactoryGetDataStore() {
        whenever(factory.getDataStore(any(), any()))
            .thenReturn(store)
    }
}