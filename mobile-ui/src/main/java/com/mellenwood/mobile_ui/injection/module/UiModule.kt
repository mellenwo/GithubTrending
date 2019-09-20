package com.mellenwood.mobile_ui.injection.module

import com.mellenwood.domain.executor.PostExecutionThread
import com.mellenwood.mobile_ui.BrowseActivity
import com.mellenwood.mobile_ui.UiThread
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class UiModule {

    @Binds
    abstract fun bindPostExecutionThread(uiThread: UiThread): PostExecutionThread

    @ContributesAndroidInjector
    abstract fun contributesBrowseActivity(): BrowseActivity

}