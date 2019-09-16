package com.mellenwood.data.mapper

import com.mellenwood.data.model.ProjectEntity
import com.mellenwood.data.test.factory.ProjectFactory
import com.mellenwood.domain.model.Project
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import kotlin.test.assertEquals

@RunWith(JUnit4::class)
class ProjectMapperTest {

    private val mapper = ProjectMapper()

    @Test
    fun mapFromEntityMapsData() {
        val projectEntity = ProjectFactory.makeProjectEntity()
        val model = mapper.mapFromEntity(projectEntity)

        assertEqualData(projectEntity, model)
    }

    @Test
    fun mapToEntityMapsData() {
        val model = ProjectFactory.makeProject()
        val entity = mapper.mapToEntity(model)

        assertEqualData(entity, model)
    }

    private fun assertEqualData(entity: ProjectEntity,
                                model: Project) {

        assertEquals(entity.id, model.id)
        assertEquals(entity.dateCreated, model.dateCreated)
        assertEquals(entity.fullName, model.fullName)
        assertEquals(entity.dateCreated, model.dateCreated)
        assertEquals(entity.isBookmarked, model.isBookmarked)
        assertEquals(entity.name, model.name)
        assertEquals(entity.ownerAvatar, model.ownerAvatar)
        assertEquals(entity.starCount, model.starCount)
        assertEquals(entity.ownerName, model.ownerName)


    }

}