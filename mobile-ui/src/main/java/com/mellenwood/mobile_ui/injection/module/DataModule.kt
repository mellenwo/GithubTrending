package com.mellenwood.mobile_ui.injection.module

import com.mellenwood.data.ProjectsDataRepository
import com.mellenwood.domain.repository.ProjectsRepository
import dagger.Binds
import dagger.Module

@Module
abstract class DataModule {

    @Binds
    abstract fun bindDataRepository(dataRepository: ProjectsDataRepository): ProjectsRepository
}