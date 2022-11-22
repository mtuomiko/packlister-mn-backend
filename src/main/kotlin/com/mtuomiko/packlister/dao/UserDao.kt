package com.mtuomiko.packlister.dao

import com.mtuomiko.packlister.model.NewUser
import com.mtuomiko.packlister.model.User

interface UserDao {
    fun create(newUser: NewUser): User
    fun getByUsername(username: String): User?
}
