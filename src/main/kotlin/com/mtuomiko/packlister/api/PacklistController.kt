package com.mtuomiko.packlister.api

import com.mtuomiko.packlister.dao.PacklistDao
import com.mtuomiko.packlister.model.Packlist
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import io.micronaut.scheduling.TaskExecutors
import io.micronaut.scheduling.annotation.ExecuteOn
import io.micronaut.security.annotation.Secured
import io.micronaut.security.rules.SecurityRule
import mu.KotlinLogging
import java.util.UUID

private val logger = KotlinLogging.logger {}

@ExecuteOn(TaskExecutors.IO)
@Secured(SecurityRule.IS_AUTHENTICATED)
@Controller("/packlists")
class PacklistController(
    private val packlistDao: PacklistDao
) {
    @Get("/{id}")
    fun getPacklist(id: UUID): Packlist? {
        logger.debug { "Fetching packlist with id '$id'"}
        return packlistDao.getOnePacklist(userId = UUID.randomUUID(), packlistId = id)
    }
}
