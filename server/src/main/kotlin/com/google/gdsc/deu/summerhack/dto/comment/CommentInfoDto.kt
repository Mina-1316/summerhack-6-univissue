package com.google.gdsc.deu.summerhack.dto.comment

//CommentInfoDto는 Request가 없음

/**
 * 댓글 요청 Dto
 */
data class CommentInfoResponseDto(
        /**
         * 작성자
         */
        val author: UserInfo,
        /**
         * 댓글 내용
         */
        val comment: String,
) {
    /**
     * 작성자 세부 정보
     */
    data class UserInfo(
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