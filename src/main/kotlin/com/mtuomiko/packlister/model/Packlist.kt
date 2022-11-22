package com.mtuomiko.packlister.model

import io.micronaut.serde.annotation.Serdeable
import java.util.UUID

@Serdeable
data class Packlist(
    val id: UUID,
    val name: String?,
    val description: String?,
    val categories: List<Category>,
    val userId: UUID
)
