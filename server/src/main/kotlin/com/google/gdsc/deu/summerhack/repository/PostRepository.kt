package com.google.gdsc.deu.summerhack.repository

import com.google.gdsc.deu.summerhack.entity.post.Post
import org.springframework.data.jpa.repository.JpaRepository

interface PostRepository : JpaRepository<Post, Long> {
    fun findByTitleLike(title: String): List<Post>


}