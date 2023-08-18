package com.google.gdsc.deu.summerhack.dto.user

data class EmailVerifyRequestDto(
    val email: String,
    val vertCode: String,
)

data class EmailVerifyResponseDto(
    val success: Boolean,
)