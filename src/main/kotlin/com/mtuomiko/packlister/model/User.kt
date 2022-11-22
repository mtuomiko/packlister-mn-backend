package com.mtuomiko.packlister.model

import java.util.UUID

data class User(
    val id: UUID,
    val username: String,
    val email: String,
    val passwordHash: String,
    val active: Boolean,
    val verified: Boolean
)
