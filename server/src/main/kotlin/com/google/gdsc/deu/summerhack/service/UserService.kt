package com.google.gdsc.deu.summerhack.service

import com.google.gdsc.deu.summerhack.dto.user.LoginRequestDto
import com.google.gdsc.deu.summerhack.dto.user.UserRegistrationRequestDto
import com.google.gdsc.deu.summerhack.entity.user.User
import com.google.gdsc.deu.summerhack.enums.UserType
import com.google.gdsc.deu.summerhack.repository.UserRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional
class UserService(
    private val userRepository: UserRepository,
) {

    /**
     * 유저를 생성하는 함수로 Validation 진행 후 유저를 DB에 저장합니다.
     *
     * @param data 생성하고자 하는 유저 정보
     */
    fun createUser(data: UserRegistrationRequestDto) {
        // Email이 office.deu.ac.kr인 경우 학생, deu.ac.kr인 경우 교직원
        val userType = when (data.email.split("@")[1]) {
            "office.deu.ac.kr" -> UserType.USER
            "deu.ac.kr" -> UserType.STAFF
            else -> error("올바른 학교 이메일이 아닙니다. 학교 이메일을 입력하세요.")
        }

        // 이메일/사용자명 중복 체크
        check(userRepository.findByEmail(data.email) != null) { "이메일은 중복될 수 없습니다." }
        check(userRepository.findByUserName(data.nickname) != null) { "사용자명은 중복될 수 없습니다." }

        // 사용자 생성
        userRepository.save(
            User(
                email = data.email,
                userName = data.nickname,
                password = data.password,
                userType = userType,
            )
        )
    }

    /**
     * 사용자 로그인을 위해 이메일을 통해 사용자를 검색하고, 비밀번호 일치 여부를 확인합니다.
     *
     * @throws IllegalStateException 로그인에 실패했을 경우
     * @param data 로그인하고자 하는 사용자 정보
     * @return 로그인에 성공한 사용자 정보
     */
    fun login(data: LoginRequestDto): User {
        // 이메일을 통한 사용자 검색
        val user = userRepository.findByEmail(data.email) ?: error("로그인에 실패했습니다.")

        // 비밀번호 일치 여부 확인
        check(user.password == data.password) { "로그인에 실패했습니다." }

        return user
    }
}