package com.google.gdsc.deu.summerhack.dto.post

data class PostRetrieveDto(
        val title: String,
        val content: String,
        val author: authorInfo,
        val recommendCnt: Long,
) {
    data class authorInfo(
            val email: String,
            val nickname: String,
    )
}