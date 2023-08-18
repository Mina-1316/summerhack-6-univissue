package com.google.gdsc.deu.summerhack.entity.user

import com.google.gdsc.deu.summerhack.enums.UserType
import jakarta.persistence.*

@Entity(name = "user")
class User(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    @Column(nullable = false, unique = true)
    val email: String,

    @Column(nullable = false, unique = true)
    val userName: String,

    @Column(nullable = false)
    val password: String,

    @Column(nullable = true)
    var authCode: String? = null,

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    val userType: UserType,
) {
}