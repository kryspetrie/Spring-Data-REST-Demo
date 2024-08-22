plugins {
	java
	id("org.springframework.boot") version "3.3.2"
	id("io.spring.dependency-management") version "1.1.6"
}

group = "com.kryspetrie"
version = "0.0.1-SNAPSHOT"

java {
	toolchain {
		languageVersion = JavaLanguageVersion.of(22)
	}
}

configurations {
	compileOnly {
		extendsFrom(configurations.annotationProcessor.get())
	}
}

repositories {
	mavenCentral()
}

dependencies {
	// Various expressive annotations
	implementation("jakarta.annotation:jakarta.annotation-api:3.0.0")
	implementation("jakarta.persistence:jakarta.persistence-api:3.2.0")

	// Core Unit Testing
	testImplementation(platform("org.junit:junit-bom:5.10.0"))
	testImplementation("org.junit.jupiter:junit-jupiter")
	testRuntimeOnly("org.junit.platform:junit-platform-launcher")

	// Fluent Assertions library
	testImplementation("org.assertj:assertj-core:3.26.3")

	// Mocking support
	testImplementation("org.mockito:mockito-core:5.12.0")
	testImplementation("org.mockito:mockito-junit-jupiter:5.12.0")

	// Google Guava Collections
	implementation("com.google.guava:guava:33.2.1-jre")

	// Spring Boot
	implementation("org.springframework.boot:spring-boot-starter-validation")
	testImplementation("org.springframework.boot:spring-boot-starter-test")

	// Spring Boot MVC
	implementation("org.springframework.boot:spring-boot-starter-web")
	implementation("org.springframework.boot:spring-boot-starter-data-jdbc")
	implementation("org.springframework.boot:spring-boot-starter-data-rest")

	// Database and Migrations
	implementation("org.flywaydb:flyway-core")
	implementation("org.flywaydb:flyway-database-postgresql")
	runtimeOnly("org.postgresql:postgresql")

	// Lombok
	compileOnly("org.projectlombok:lombok")
	annotationProcessor("org.projectlombok:lombok")
}

tasks.withType<Test> {
	useJUnitPlatform()
}
