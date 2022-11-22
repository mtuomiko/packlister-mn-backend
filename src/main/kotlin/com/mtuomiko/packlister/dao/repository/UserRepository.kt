package com.mtuomiko.packlister.dao.repository

import com.mtuomiko.packlister.dao.entity.UserEntity
import io.micronaut.data.annotation.Repository
import io.micronaut.data.repository.CrudRepository
import java.util.UUID

@Repository
interface UserRepository : CrudRepository<UserEntity, UUID> {
    fun findByUsernameIgnoreCase(username: String): UserEntity?
}
