package com.mtuomiko.packlister.dao.entity

import com.mtuomiko.packlister.model.UserItem
import io.micronaut.data.annotation.DateCreated
import io.micronaut.data.annotation.DateUpdated
import java.time.Instant
import java.util.UUID
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "items")
class UserItemEntity(
    @Id
    val id: UUID,
    val name: String?,
    val description: String?,
    val weight: Int?,
    val publicVisibility: Boolean = false,
    @Column(name = "account_id")
    val userId: UUID
) {
    @field:DateUpdated
    lateinit var modifiedAt: Instant

    @field:DateCreated
    @Column(updatable = false)
    lateinit var createdAt: Instant

    fun toModel() = with(this) { UserItem(id, name, description, weight, publicVisibility) }
}
