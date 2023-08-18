package com.google.gdsc.deu.summerhack.dto.post

//request가 없음

/**
 * 댓글 요청 Dto
 */
data class PostRetrieveResponseDto(
        /**
         * 제목
         */
        val title: String,
        /**
         * 내용
         */
        val content: String,
        /**
         * 저자
         */
        val author: AuthorInfo,
        /**
         * 추천 수
         */
        val recommendCnt: Long,
) {
    /**
     * 작성자 정보
     */
    data class AuthorInfo(
            /**
             * 이메일
             */
            val email: String,
            /**
             * 닉네임
             */
            val nickname: String,
    )
}