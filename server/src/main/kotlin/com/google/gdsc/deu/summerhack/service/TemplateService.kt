package com.google.gdsc.deu.summerhack.service

import com.github.mustachejava.DefaultMustacheFactory
import org.springframework.core.io.ClassPathResource
import org.springframework.stereotype.Service
import java.io.InputStreamReader
import java.io.StringWriter

@Service
class TemplateService {
    private val mustacheFactory = DefaultMustacheFactory()

    fun applyTemplate(resourcePath: String, data: Map<String, Any?>): String =
        applyTemplate(InputStreamReader(ClassPathResource(resourcePath).inputStream), data)

    fun applyTemplate(templateReader: InputStreamReader, data: Map<String, Any?>): String {
        val writer = StringWriter()
        mustacheFactory.compile(templateReader, "generated")
            .execute(writer, data)
            .flush()

        return writer.toString()
    }
}