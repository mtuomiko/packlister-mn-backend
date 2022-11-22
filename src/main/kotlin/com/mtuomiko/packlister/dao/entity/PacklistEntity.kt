package com.mtuomiko.packlister.dao.entity

import com.mtuomiko.packlister.model.Category
import com.mtuomiko.packlister.model.Packlist
import io.micronaut.data.annotation.DateCreated
import io.micronaut.data.annotation.DateUpdated
import org.hibernate.annotations.Type
import java.time.Instant
import java.util.UUID
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "packlists")
class PacklistEntity(
    @Id
    val id: UUID,
    val name: String?,
    val description: String?,
    @Type(type = "com.vladmihalcea.hibernate.type.json.JsonType")
    @Column(name = "content", columnDefinition = "jsonb")
    val categories: List<Category>,
    @Column(name = "account_id")
    val userId: UUID
) {
    @field:DateUpdated
    lateinit var modifiedAt: Instant

    @field:DateCreated
    @Column(updatable = false)
    lateinit var createdAt: Instant

    fun toModel() = with(this) { Packlist(id, name, description, categories, userId) }
}
