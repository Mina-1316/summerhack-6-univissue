package com.google.gdsc.deu.summerhack.dto.post

/**
 * 게시글 작성을 위한 데이터 클래스
 */
data class PostCreationRequestDto(
    /**
     * 게시글 제목
     */
    val title: String,
    /**
     * 게시글 내용
     */
    val content: String,
)

// 게시글 작성 API에는 Response가 존재하지 않음