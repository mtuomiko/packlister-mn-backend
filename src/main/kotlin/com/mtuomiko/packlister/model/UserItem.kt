package com.mtuomiko.packlister.model

import io.micronaut.serde.annotation.Serdeable
import java.util.UUID

@Serdeable
class UserItem(
    val id: UUID,
    val name: String?,
    val description: String?,
    val weight: Int?,
    val publicVisibility: Boolean = false
)
