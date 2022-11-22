package com.mtuomiko.packlister.model

data class NewUser(
    val username: String,
    val email: String,
    val passwordHash: String,
    val active: Boolean,
    val verified: Boolean
)
