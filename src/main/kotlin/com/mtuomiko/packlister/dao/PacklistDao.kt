package com.mtuomiko.packlister.dao

import com.mtuomiko.packlister.model.Packlist
import com.mtuomiko.packlister.model.PacklistLimited
import java.util.UUID

interface PacklistDao {
    fun getUserPacklists(userId: UUID): List<PacklistLimited>
    fun getOnePacklist(userId: UUID, packlistId: UUID): Packlist?
    fun createPacklist(userId: UUID, packlist: Packlist): Packlist
    fun updatePacklist(userId: UUID, packlist: Packlist): Packlist
}
