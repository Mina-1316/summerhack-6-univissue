package com.google.gdsc.deu.summerhack.controller

import com.google.gdsc.deu.summerhack.dto.user.LoginRequestDto
import com.google.gdsc.deu.summerhack.dto.user.LoginResponseDto
import com.google.gdsc.deu.summerhack.dto.user.UserRegistrationRequestDto
import com.google.gdsc.deu.summerhack.dto.user.UserRegistrationResponseDto
import com.google.gdsc.deu.summerhack.service.UserService
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/user")
class UserController(
    private val userService: UserService,
) {

    /**
     * 유저 정보를 생성(회원 가입)하는 API.
     *
     * @param request 회원가입 하고자 하는 유저 정보
     * @return 회원가입 작업 결과 - 실패시 에러 메시지를 반환
     */
    @PostMapping()
    fun createUser(@RequestBody request: UserRegistrationRequestDto): UserRegistrationResponseDto {
        userService.createUser(request)

        return UserRegistrationResponseDto(
            message = "SUCCESS"
        )
    }

    /**
     * 로그인을 위한 API
     * @param request 로그인하고자 하는 유저 정보
     * @return 로그인 작업 결과 - 실패 시 에러 메시지를 반환
     */
    @PostMapping("/login")
    fun login(@RequestBody request: LoginRequestDto): LoginResponseDto {
        userService.login(request)

        return LoginResponseDto(
            token = "login success"
        )
    }

}