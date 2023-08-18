package com.google.gdsc.deu.summerhack.dto.user

data class UserRegistrationRequestDto(
    /**
     * 사용자 이름
     */
    val nickname: String,
    /**
     * 이메일. office.deu.ac.kr 혹은 deu.ac.kr 이메일만 수락 가능합니다.
     */
    val email: String,
    /**
     * 비밀번호
     */
    val password: String,
)

data class UserRegistrationResponseDto(
    /**
     * 실행 후 에러 발생시 메시지
     */
    val message: String,
)
