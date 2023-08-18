package com.google.gdsc.deu.summerhack.controller

import com.google.gdsc.deu.summerhack.dto.post.PostCreationRequestDto
import com.google.gdsc.deu.summerhack.dto.post.PostListRetrieveResponseDto
import com.google.gdsc.deu.summerhack.dto.post.PostRetrieveResponseDto
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/v1/post")
class PostController {
    /**
     * 게시글 작성을 위한 API
     * @param request 작성하고자 하는 게시글 정보
     * @return 게시글 작성 결과 - 실패시 에러 메시지를 반환
     */
    @PostMapping()
    fun createPost(@RequestBody request: PostCreationRequestDto) {
    }


    /**
     * 게시글을 불러오기 위한 API
     * @param request 불러오고자 하는 게시글 정보
     * @return 게시글 불러오기 결과 - 실패 시 에러 메시지를 반환
     */
    @GetMapping("/{postId}")
    fun retrievePost(@PathVariable postId: String): PostRetrieveResponseDto {
        return PostRetrieveResponseDto(
            title = "title",
            content = "content",
            author = PostRetrieveResponseDto.AuthorInfo(
                email = "email",
                nickname = "nickname",
            ),
            recommendCnt = 0
        )
    }

    /**
     * 게시글 리스트를 불러오기 위한 API
     * @param request 전체 게시글 리스트
     * @return 게시글 리스트 불러오기 결과 - 실패 시 에러 메시지를 반환
     */
    @GetMapping()
    fun retrievePostList(): PostListRetrieveResponseDto {
        return PostListRetrieveResponseDto(
            posts = listOf(),
        )
    }
}