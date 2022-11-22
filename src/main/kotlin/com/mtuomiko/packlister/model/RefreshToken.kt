package com.mtuomiko.packlister.model

import java.time.Instant
import java.util.UUID

class RefreshToken(
    val id: UUID,
    val token: String,
    val family: UUID,
    val expiresAt: Instant,
    val userId: UUID
)
