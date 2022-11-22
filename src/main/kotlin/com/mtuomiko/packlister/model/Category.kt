package com.mtuomiko.packlister.model

import io.micronaut.serde.annotation.Serdeable
import java.util.UUID

@Serdeable
data class Category(
    val id: UUID,
    val name: String?,
    val categoryItems: List<CategoryItem>
)

