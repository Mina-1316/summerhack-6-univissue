package com.google.gdsc.deu.summerhack.dto.post

import java.time.LocalDateTime

// 게시글 조회는 Query String을 사용하기 때문에 Request가 존재하지 않음

/**
 * 게시글 목록 조회 API의 Response
 */
data class PostListRetrieveResponseDto(
    /**
     * 게시글 목록
     */
    val posts: List<PostRetrieveDto>,
) {
    /**
     * 게시글 내용
     */
    data class PostRetrieveDto(
        /**
         * 게시글 ID
         */
        val id: Long,
        /**
         * 게시글 제목
         */
        val title: String,
        /**
         * 게시글 작성자
         */
        val author: PostUserInfo,
        /**
         * 게시글 작성 시간
         */
        val createdAt: LocalDateTime,
    )

    /**
     * 게시글 작성자 정보
     */
    data class PostUserInfo(
        /**
         * 이메일
         */
        val email: String,
        /**
         * 작성자 이름
         */
        val nickname: String,
    )
}