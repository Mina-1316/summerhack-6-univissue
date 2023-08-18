package com.google.gdsc.deu.summerhack.entity.user

import jakarta.persistence.*

@Entity
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
) {
}