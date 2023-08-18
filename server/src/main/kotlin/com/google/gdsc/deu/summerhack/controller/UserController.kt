package com.google.gdsc.deu.summerhack.controller

import com.google.gdsc.deu.summerhack.dto.user.LoginRequestDto
import com.google.gdsc.deu.summerhack.dto.user.LoginResponseDto
import com.google.gdsc.deu.summerhack.dto.user.UserRegistrationRequestDto
import com.google.gdsc.deu.summerhack.dto.user.UserRegistrationResponseDto
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/user")
class UserController {

    /**
     * 유저 정보를 생성(회원 가입)하는 API.
     *
     * @param request 회원가입 하고자 하는 유저 정보
     * @return 회원가입 작업 결과 - 실패시 에러 메시지를 반환
     */
    @PostMapping()
    fun createUser(@RequestBody request: UserRegistrationRequestDto): UserRegistrationResponseDto {

        return UserRegistrationResponseDto(
                message = "success"
        )
    }

    /**
     * 로그인을 위한 API
     * @param request - 로그인하고자 하는 유저 정보
     * @Returns: 로그인 작업 결과 - 실패 시 에러 메시지를 반환
     */
    @PostMapping()
    fun login(@RequestBody request: LoginRequestDto): LoginResponseDto {

        return LoginResponseDto(
                token = "login success"
        )
    }

}