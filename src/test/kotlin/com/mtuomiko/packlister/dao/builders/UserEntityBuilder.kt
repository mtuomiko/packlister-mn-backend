package com.mtuomiko.packlister.dao.builders

import com.mtuomiko.packlister.dao.entity.UserEntity
import java.util.UUID

class UserEntityBuilder {
    var id: UUID = UUID.randomUUID()
    var username: String = "user"
    var email: String = "user@example.com"
    var passwordHash: String = "foobar"
    var active: Boolean = true
    var verified: Boolean = true

    fun id(id: UUID) = apply { this.id = id }
    fun username(username: String) = apply { this.username = username }
    fun email(email: String) = apply { this.email = email }
    fun passwordHash(passwordHash: String) = apply { this.passwordHash = passwordHash }
    fun active(active: Boolean) = apply { this.active = active }
    fun verified(verified: Boolean) = apply { this.verified = verified }

    fun build() = UserEntity(
        id,
        username,
        email,
        passwordHash,
        active,
        verified
    )
}
