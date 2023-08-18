package com.google.gdsc.deu.summerhack.handler

import com.google.gdsc.deu.summerhack.dto.ErrorMessageDto
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestController

@ControllerAdvice
@RestController
class UniversalExceptionAdvisor {
    @ExceptionHandler(value = [IllegalStateException::class])
    // Return 400 with ErrorMessageDto
    fun handleIllegalStateException(e: IllegalStateException): ResponseEntity<ErrorMessageDto> {
        return ResponseEntity(ErrorMessageDto(e.message ?: "Unknown Error"), HttpStatus.BAD_REQUEST)
    }
}