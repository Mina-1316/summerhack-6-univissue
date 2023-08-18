package com.google.gdsc.deu.summerhack.service

import com.google.gdsc.deu.summerhack.dto.post.PostCreationRequestDto
import com.google.gdsc.deu.summerhack.entity.post.Post
import com.google.gdsc.deu.summerhack.entity.user.User
import com.google.gdsc.deu.summerhack.repository.PostRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional(rollbackFor = [Exception::class])
class PostService(
        private val postRepository: PostRepository,
) {
    fun createPost(postData: PostCreationRequestDto, userData: User): Post {
        val postInfo = Post(
                title = postData.title,
                content = postData.content,
                userId = userData.id,
        )

        return postRepository.save(postInfo)
    }

    fun retrievePost(postIdxData: Long): Post {
        return postRepository.findById(postIdxData).orElseThrow { IllegalStateException("존재하지 않는 글입니다.") }
    }
}