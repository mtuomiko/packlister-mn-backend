package com.mtuomiko.packlister.dao.repository

import com.mtuomiko.packlister.dao.entity.PacklistEntity
import com.mtuomiko.packlister.dao.projection.PacklistLimitedView
import io.micronaut.data.annotation.Repository
import io.micronaut.data.repository.CrudRepository
import java.util.UUID

@Repository
interface PacklistRepository : CrudRepository<PacklistEntity, UUID> {
    fun findByUserId(userId: UUID): List<PacklistLimitedView>
}
