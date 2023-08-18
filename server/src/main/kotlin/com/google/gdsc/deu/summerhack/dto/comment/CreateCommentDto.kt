package com.google.gdsc.deu.summerhack.dto.comment

/**
 * 댓글 생성 Dto
 */
data class CreateCommentRequestDto(
        /**
         * 댓글 내용
         */
        val comment: String,
)
// 댓글 생성 api는 Response가 없음