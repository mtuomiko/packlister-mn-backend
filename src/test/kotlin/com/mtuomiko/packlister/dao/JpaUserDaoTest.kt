package com.mtuomiko.packlister.dao

import com.mtuomiko.packlister.dao.builders.UserEntityBuilder
import com.mtuomiko.packlister.dao.repository.UserRepository
import com.mtuomiko.packlister.model.NewUser
import com.mtuomiko.packlister.model.User
import io.micronaut.test.extensions.junit5.annotation.MicronautTest
import jakarta.inject.Inject
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import java.util.UUID

@MicronautTest
private class JpaUserDaoTest(
    @Inject
    private val userRepository: UserRepository
) {
    private val userDao = JpaUserDao(userRepository)
    private val testUserIds = listOf("30b5ac32-7fb8-4877-9b31-685bc8232c90", "30b5ac32-7fb8-4877-9b31-685bc8232c91")
        .map(UUID::fromString)

    // Setup is invoked manually in test since MicronautTest doesn't rollback BeforeEach annotated methods
    private fun createInitialUsers() {
        val userEntities = testUserIds.mapIndexed { i, id ->
            UserEntityBuilder().id(id).username("user$i").email("user$i@example.com").build()
        }
        userRepository.saveAll(userEntities)
    }

    @Test
    fun `getting User by username when user doesn't exist returns null`() {
        val returnedUser = userDao.getByUsername("foobar")

        assertThat(returnedUser).isNull()
    }

    @Test
    fun `getting User by username when user exists returns User`() {
        val testUserId = testUserIds[0]
        val testUserEntity = UserEntityBuilder().id(testUserId).username("meeko").email("meeko@example.com").build()
        userRepository.save(testUserEntity)

        val returnedUser = userDao.getByUsername("meeko")

        val expected = testUserEntity.toModel()
        assertThat(returnedUser).isEqualTo(expected)
    }

    @Test
    fun `creating user when user has unique username and email will return and create User`() {
        createInitialUsers()
        val newUser = NewUser(
            username = "meeko",
            email = "meeko@example.com",
            passwordHash = "hashvaluenotrelevant",
            active = true,
            verified = true
        )

        val createdUser = userDao.create(newUser)

        val userFromRepository = userRepository.findByUsernameIgnoreCase("MEEKO")!!.toModel()

        assertThat(createdUser).isEqualTo(userFromRepository)
        createdUser.assertEquivalentTo(newUser)
        userFromRepository.assertEquivalentTo(newUser)
    }

    private fun User.assertEquivalentTo(newUser: NewUser) {
        assertThat(username).isEqualTo(newUser.username)
        assertThat(email).isEqualTo(newUser.email)
        assertThat(passwordHash).isEqualTo(newUser.passwordHash)
        assertThat(active).isEqualTo(newUser.active)
        assertThat(verified).isEqualTo(newUser.verified)
    }
}
