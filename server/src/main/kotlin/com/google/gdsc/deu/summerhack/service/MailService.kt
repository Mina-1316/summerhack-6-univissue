package com.google.gdsc.deu.summerhack.service

import org.springframework.beans.factory.annotation.Value
import org.springframework.mail.javamail.JavaMailSender
import org.springframework.mail.javamail.MimeMessageHelper
import org.springframework.stereotype.Service

@Service
class MailService(
    private val javaMailSender: JavaMailSender,

    @Value("\${spring.mail.from}")
    private val from: String,
) {

    fun sendMail(
        to: String,
        text: String,
        isHtml: Boolean = true,
        subject: String,
    ) {
        val message = javaMailSender.createMimeMessage()
        MimeMessageHelper(message, true)
            .apply {
                setTo(to)
                setFrom(from)
                setText(text, isHtml)
                setSubject(subject)
            }
        javaMailSender.send(message)

    }

}