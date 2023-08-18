package com.google.gdsc.deu.summerhack.controller

import com.google.gdsc.deu.summerhack.dto.comment.CommentInfoResponseDto
import com.google.gdsc.deu.summerhack.dto.comment.CreateCommentRequestDto
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/v1/comment")
class CommentController {
    /**
     * 댓글을 작성하기 위한 API
     * @param request 작성할 댓글
     */
    @PostMapping
    fun createComment(@RequestBody request: CreateCommentRequestDto) {
    }

    /**
     * 댓글 리스트를 불러오기 위한 API
     * @return 댓글 리스트 불러오기 결과 - 실패 시 에러 메시지를 반환
     */
    @GetMapping
    fun showComment(): CommentInfoResponseDto {
        return CommentInfoResponseDto(
                author = CommentInfoResponseDto.UserInfo(
                        email = "test@test.com",
                        nickname = "",
                ),
                comment = "",
        )
    }
}