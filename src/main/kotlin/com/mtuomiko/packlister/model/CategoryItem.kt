package com.mtuomiko.packlister.model

import io.micronaut.serde.annotation.Serdeable
import java.util.UUID

@Serdeable
data class CategoryItem(
    val userItemId: UUID,
    val quantity: Int
)

