package com.google.gdsc.deu.summerhack.controller

import com.google.gdsc.deu.summerhack.dto.user.*
import com.google.gdsc.deu.summerhack.service.JwtService
import com.google.gdsc.deu.summerhack.service.MailService
import com.google.gdsc.deu.summerhack.service.TemplateService
import com.google.gdsc.deu.summerhack.service.UserService
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/user")
class UserController(
    private val userService: UserService,
    private val mailService: MailService,
    private val templateService: TemplateService,
    private val jwtService: JwtService,
) {

    /**
     * 유저 정보를 생성(회원 가입)하는 API.
     *
     * @param request 회원가입 하고자 하는 유저 정보
     * @return 회원가입 작업 결과 - 실패시 에러 메시지를 반환
     */
    @PostMapping()
    fun createUser(@RequestBody request: UserRegistrationRequestDto): UserRegistrationResponseDto {
        val user = userService.createUser(request)

        val emailString = templateService.applyTemplate(
            "mail/registration.mustache", mapOf(
                "authCode" to user.authCode
            )
        )

        mailService.sendMail(
            subject = "DEU Summer Hack 2023 회원가입 인증 메일입니다.",
            to = request.email,
            text = emailString
        )

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
        val user = userService.login(request)

        // JWT 토큰 생성
        val token = jwtService.generateToken(user)

        return LoginResponseDto(
            token = token
        )
    }

    @PostMapping("/email-vert")
    fun emailVerify(@RequestBody request: EmailVerifyRequestDto): EmailVerifyResponseDto {
        val verifyResult = userService.verity(request)

        return EmailVerifyResponseDto(
            success = verifyResult
        )
    }


}