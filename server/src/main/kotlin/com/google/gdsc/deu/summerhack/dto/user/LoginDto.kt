package com.google.gdsc.deu.summerhack.dto.user

/**
 * 로그인 요청 Dto
 */
data class LoginRequestDto(
        /**
         * 이메일
         */
        val email: String,
        /**
         * 비밀번호
         */
        val password: String,
)

/**
 * 로그인 응답 Dto
 */
data class LoginResponseDto(
        /**
         * JWT
         */
        val token: String,
)