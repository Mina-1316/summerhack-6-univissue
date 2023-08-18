package com.google.gdsc.deu.summerhack.repository

import com.google.gdsc.deu.summerhack.entity.user.User
import org.springframework.data.jpa.repository.JpaRepository

interface UserRepository : JpaRepository<User, Long> {

    fun findByEmail(email: String): User?


}