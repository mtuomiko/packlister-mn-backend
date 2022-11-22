package com.mtuomiko.packlister.dao

import com.mtuomiko.packlister.dao.entity.UserEntity
import com.mtuomiko.packlister.dao.repository.UserRepository
import com.mtuomiko.packlister.model.NewUser
import com.mtuomiko.packlister.model.User
import jakarta.inject.Inject
import jakarta.inject.Singleton
import java.util.UUID
import javax.transaction.Transactional

@Singleton
open class JpaUserDao(
    @Inject
    private val userRepository: UserRepository
) : UserDao {
    @Transactional
    override fun create(newUser: NewUser): User {
        val userEntity = with(newUser) {
            UserEntity(id = UUID.randomUUID(), username, email, passwordHash, active, verified)
        }
        val savedEntity = userRepository.save(userEntity)
        return savedEntity.toModel()
    }

    override fun getByUsername(username: String): User? {
        return userRepository.findByUsernameIgnoreCase(username)?.toModel()
    }
}
