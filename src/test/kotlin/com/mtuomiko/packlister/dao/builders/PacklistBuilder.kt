package com.mtuomiko.packlister.dao.builders

import com.mtuomiko.packlister.model.Category
import com.mtuomiko.packlister.model.Packlist
import java.util.UUID

class PacklistBuilder {
    var id: UUID = UUID.randomUUID()
    var name: String? = "user"
    var description: String? = "my packlist"
    var categories: List<Category> = emptyList()
    var userId: UUID = UUID.randomUUID()

    fun id(id: UUID) = apply { this.id = id }
    fun name(name: String) = apply { this.name = name }
    fun description(description: String) = apply { this.description = this.description }
    fun categories(categories: List<Category>) = apply { this.categories = categories }
    fun userId(userId: UUID) = apply { this.userId = userId }

    fun build() = Packlist(id, name, description, categories, userId)
}
