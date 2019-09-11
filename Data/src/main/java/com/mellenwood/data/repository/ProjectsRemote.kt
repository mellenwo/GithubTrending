package com.mellenwood.data.repository

import com.mellenwood.data.model.ProjectEntity
import io.reactivex.Completable
import io.reactivex.Observable

interface ProjectsRemote {

    fun getProjects(): Observable<List<ProjectEntity>>

}