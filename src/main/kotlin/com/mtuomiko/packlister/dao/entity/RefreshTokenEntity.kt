package com.mtuomiko.packlister.dao.entity

import com.mtuomiko.packlister.model.RefreshToken
import io.micronaut.data.annotation.DateCreated
import io.micronaut.data.annotation.DateUpdated
import java.time.Instant
import java.util.UUID
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "refresh_tokens")
class RefreshTokenEntity(
    @Id
    val id: UUID,
    val token: String,
    val family: UUID,
    @Column(name = "expires_at")
    val expiresAt: Instant,
    @Column(name = "account_id")
    val userId: UUID
) {
    @field:DateUpdated
    lateinit var modifiedAt: Instant

    @field:DateCreated
    @Column(updatable = false)
    lateinit var createdAt: Instant

    fun toModel() = with(this) { RefreshToken(id, token, family, expiresAt, userId) }
}
