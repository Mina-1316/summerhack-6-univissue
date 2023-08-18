import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
	// Spring Boot
	id("org.springframework.boot") version "3.1.2"
	id("io.spring.dependency-management") version "1.1.2"
	// KAPT(Kotlin Annotation Processor)
	id("org.jetbrains.kotlin.kapt") version "1.8.22"
	// Kotlin
	kotlin("jvm") version "1.8.22"
	kotlin("plugin.spring") version "1.8.22"
	kotlin("plugin.jpa") version "1.8.22"
}

group = "com.google.gdsc.deu"
version = "0.0.1-SNAPSHOT"

java {
	sourceCompatibility = JavaVersion.VERSION_17
}

repositories {
	mavenCentral()
}

// == Dependencies ==
dependencies {
	// Spring boot
	implementation("org.springframework.boot:spring-boot-starter-data-jpa")
	implementation("org.springframework.boot:spring-boot-starter-web")
	implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
	developmentOnly("org.springframework.boot:spring-boot-devtools")

	// Kotlin
	implementation("org.jetbrains.kotlin:kotlin-reflect")

	// Datasource(MySQL)
	implementation("mysql:mysql-connector-java:8.0.33")

	// SpringDoc
	implementation("org.springdoc:springdoc-openapi-ui:1.6.15")
	implementation("org.springdoc:springdoc-openapi-kotlin:1.6.15")
	annotationProcessor("org.springdoc:springdoc-openapi-javadoc:1.6.15")
	kapt("org.springdoc:springdoc-openapi-javadoc:1.6.15")

}

// == Test Dependencies ==
dependencies {
	testImplementation("org.springframework.boot:spring-boot-starter-test")
}

tasks.withType<KotlinCompile> {
	kotlinOptions {
		freeCompilerArgs += "-Xjsr305=strict"
		jvmTarget = "17"
	}
}

tasks.withType<Test> {
	useJUnitPlatform()
}
