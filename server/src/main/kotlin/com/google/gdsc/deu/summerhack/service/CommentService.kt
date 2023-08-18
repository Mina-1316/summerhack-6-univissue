package com.google.gdsc.deu.summerhack.service

import com.google.gdsc.deu.summerhack.dto.comment.CreateCommentRequestDto
import com.google.gdsc.deu.summerhack.entity.comment.Comment
import com.google.gdsc.deu.summerhack.entity.post.Post
import com.google.gdsc.deu.summerhack.entity.user.User
import com.google.gdsc.deu.summerhack.repository.CommentRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional(rollbackFor = [Exception::class])
class CommentService(
        private val commentRepository: CommentRepository,
) {
    fun createComment(commentData: CreateCommentRequestDto,
                      userData: User, postData: Post): Comment {
        val commentInfo = Comment(
                content = commentData.comment,
                userId = userData.id,
                postId = postData.id,
        )

        return commentRepository.save(
                commentInfo
        )
    }

    fun retrieveComment(postIdxData: Long, commentData: Comment): List<Comment> {
        return commentRepository.findByPostId(postIdxData)
    }
}