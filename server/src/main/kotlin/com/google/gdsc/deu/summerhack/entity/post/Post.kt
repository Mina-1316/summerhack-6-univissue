package com.google.gdsc.deu.summerhack.entity.post

import jakarta.persistence.*

@Entity
class Post(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        val id: Long = 0,

        @Column(nullable = false, unique = false)
        val title: String,

        @Column(nullable = false, unique = false)
        val content: String,

        @Column(nullable = false, unique = false)
        val userId: Long,

        @Column(nullable = false, unique = false)
        val recommendCnt: Long = 0,
) {
}