package com.google.gdsc.deu.summerhack.service

import com.google.gdsc.deu.summerhack.entity.user.User
import io.jsonwebtoken.Jwts
import io.jsonwebtoken.SignatureAlgorithm
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service

@Service
class JwtService(
    @Value("\${application.jwt.secret}")
    private val secretKey: String,

    @Value("\${application.jwt.expiration}")
    private val expiration: Long,
) {
    fun generateToken(user: User): String {
        val jwtPayload = JwtPayload(
            id = user.id,
            email = user.email,
            userName = user.userName,
            userType = user.userType.name,
        )

        // Create JWT Token
        return Jwts.builder()
            .setSubject("user")
            .claim("user", jwtPayload)
            .signWith(SignatureAlgorithm.HS256, secretKey)
            .compact()
    }

    fun validateToken(token: String): Boolean {
        return try {
            Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token)
            true
        } catch (e: Exception) {
            false
        }
    }

    fun getPayload(token: String): JwtPayload {
        val claims = Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token).body
        return claims["user"] as JwtPayload
    }

    data class JwtPayload(
        val id: Long,
        val email: String,
        val userName: String,
        val userType: String,
    )
}