package com.mellenwood.mobile_ui.injection.module

import com.mellenwood.data.repository.ProjectsRemote
import com.mellenwood.mobile_ui.BuildConfig
import com.mellenwood.remote.ProjectsRemoteImpl
import com.mellenwood.remote.service.GithubTrendingService
import com.mellenwood.remote.service.GithubTrendingServiceFactory
import dagger.Binds
import dagger.Module
import dagger.Provides

@Module
abstract class RemoteModule {

    @Module
    companion object {
        @Provides
        @JvmStatic
        fun provideGithubService(): GithubTrendingService {
            return GithubTrendingServiceFactory.makeGithubTrendingService(BuildConfig.DEBUG)
        }
    }

    @Binds
    abstract fun bindProjectsRemote(projectsRemote: ProjectsRemoteImpl): ProjectsRemote
}