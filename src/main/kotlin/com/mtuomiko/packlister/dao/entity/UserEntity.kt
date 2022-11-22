package com.mtuomiko.packlister.dao.entity

import com.mtuomiko.packlister.model.User
import io.micronaut.data.annotation.DateCreated
import io.micronaut.data.annotation.DateUpdated
import java.time.Instant
import java.util.UUID
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "accounts")
class UserEntity(
    @Id
    val id: UUID,
    val username: String,
    val email: String,
    val passwordHash: String,
    val active: Boolean,
    val verified: Boolean
) {
    @field:DateUpdated
    lateinit var modifiedAt: Instant

    @field:DateCreated
    @Column(updatable = false)
    lateinit var createdAt: Instant

    fun toModel() = with(this) { User(id, username, email, passwordHash, active, verified) }
}
