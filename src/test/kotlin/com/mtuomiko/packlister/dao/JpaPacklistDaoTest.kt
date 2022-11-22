package com.mtuomiko.packlister.dao

import com.mtuomiko.packlister.dao.builders.PacklistBuilder
import com.mtuomiko.packlister.dao.builders.UserEntityBuilder
import com.mtuomiko.packlister.dao.entity.PacklistEntity
import com.mtuomiko.packlister.dao.repository.PacklistRepository
import com.mtuomiko.packlister.dao.repository.UserRepository
import com.mtuomiko.packlister.model.PacklistLimited
import io.micronaut.test.extensions.junit5.annotation.MicronautTest
import jakarta.inject.Inject
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import java.util.UUID

@MicronautTest
private class JpaPacklistDaoTest(
    @Inject
    private val packlistRepository: PacklistRepository,
    @Inject
    private val userRepository: UserRepository
) {
    private val packlistDao = JpaPacklistDao(packlistRepository)
    private val testUserIds = listOf("30b5ac32-7fb8-4877-9b31-685bc8232c90", "30b5ac32-7fb8-4877-9b31-685bc8232c91")
        .map(UUID::fromString)
    private val testPacklists = testUserIds.flatMap { userId ->
        List(2) { }.map { PacklistBuilder().userId(userId).build() }
    }

    //Setup is invoked manually in test since MicronautTest doesn't rollback BeforeEach annotated methods
    private fun setup() {
        val userEntities = testUserIds.mapIndexed { i, id ->
            UserEntityBuilder().id(id).username("user$i").email("user$i@example.com").build()
        }
        userRepository.saveAll(userEntities)
        val packlistEntities =
            testPacklists.map { PacklistEntity(it.id, it.name, it.description, it.categories, it.userId) }
        packlistRepository.saveAll(packlistEntities)
    }

    @Test
    fun userExists_creatingPacklist_ReturnsPacklistAndItsSaved() {
        setup()
        val testUserId = testUserIds[0]
        val packlist = PacklistBuilder().userId(testUserId).build()

        val createdPacklist = packlistDao.createPacklist(testUserId, packlist)

        val expected = packlist.copy()
        val fromRepository = packlistRepository.findById(packlist.id).get()
        val packlistFromRepository = fromRepository.toModel()
        assertThat(createdPacklist).isEqualTo(expected)
        assertThat(packlistFromRepository).isEqualTo(expected)
    }

    @Test
    fun userAndPacklistsExist_gettingAllUserPacklists_returnsAllUsersPacklistProjections() {
        setup()
        val testUserId = testUserIds[1]

        val userPacklists = packlistDao.getUserPacklists(testUserId)

        val expectedPacklists = testPacklists.filter { it.userId == testUserId }
            .map { PacklistLimited(id = it.id, name = it.name) }
        assertThat(userPacklists).containsExactlyInAnyOrderElementsOf(expectedPacklists)
    }
}
