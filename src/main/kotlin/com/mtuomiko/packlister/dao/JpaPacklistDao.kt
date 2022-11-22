package com.mtuomiko.packlister.dao

import com.mtuomiko.packlister.dao.entity.PacklistEntity
import com.mtuomiko.packlister.dao.repository.PacklistRepository
import com.mtuomiko.packlister.model.Packlist
import com.mtuomiko.packlister.model.PacklistLimited
import jakarta.inject.Singleton
import java.util.UUID
import javax.transaction.Transactional

@Singleton
open class JpaPacklistDao(
    private val packlistRepository: PacklistRepository
) : PacklistDao {
    override fun getUserPacklists(userId: UUID): List<PacklistLimited> {
        val packlistProjections = packlistRepository.findByUserId(userId)
        return packlistProjections.map { PacklistLimited(it.id, it.name) }
    }

    override fun getOnePacklist(userId: UUID, packlistId: UUID): Packlist? {
        val packlistOpt = packlistRepository.findById(packlistId)
        if (packlistOpt.isEmpty) return null

        val packlist = packlistOpt.get()
        return Packlist(
            id = packlist.id,
            name = packlist.name,
            description = packlist.description,
            categories = packlist.categories,
            userId = packlist.userId
        )
    }

    @Transactional
    override fun createPacklist(userId: UUID, packlist: Packlist): Packlist {
        val entity = packlist.toEntity(userId)
        return packlistRepository.save(entity).toModel()
    }

    @Transactional
    override fun updatePacklist(userId: UUID, packlist: Packlist): Packlist {
        val existingPacklist = packlistRepository.findById(packlist.id).orElseThrow {
            Error("packlist with id ${packlist.id} not found")
        }
        if (existingPacklist.userId != userId) {
            throw Error("not allowed to modify packlists of other users")
        }
//        packlistRepository.session().clear() // clear existing entity from session
        val entity = packlist.toEntity(userId)
        return packlistRepository.update(entity).toModel()
    }

    private fun Packlist.toEntity(userId: UUID) = with(this) {
        PacklistEntity(id, name, description, categories, userId)
    }
}
