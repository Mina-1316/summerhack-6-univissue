package com.google.gdsc.deu.summerhack.repository

import com.google.gdsc.deu.summerhack.entity.comment.Comment
import org.springframework.data.jpa.repository.JpaRepository

interface CommentRepository : JpaRepository<Comment, Long> {
    fun findByPostId(postId: Long): List<Comment>
}