package com.mtuomiko.packlister.dao.projection

import io.micronaut.core.annotation.Introspected
import java.util.UUID

@Introspected
class PacklistLimitedView(
    val id: UUID,
    val name: String?,
    val userId: UUID
)
