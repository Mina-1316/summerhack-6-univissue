package com.google.gdsc.deu.summerhack.entity.comment

import jakarta.persistence.*

@Entity(name = "comment")
class Comment(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    @Column(nullable = false, unique = false)
    val content: String,

    @Column(nullable = false, unique = false)
    val userId: Long,

    @Column(nullable = false, unique = false)
    val postId: Long,
) {
}