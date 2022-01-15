import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

val postgreVersion by extra("42.2.17")

buildscript {
	dependencies {
		classpath("org.jetbrains.kotlin:kotlin-noarg:1.4.30")
	}
}

apply {
	plugin("kotlin-jpa")
}

plugins {
	id("org.springframework.boot") version "2.5.0"
	id("io.spring.dependency-management") version "1.0.11.RELEASE"
	kotlin("jvm") version "1.5.10"
	kotlin("plugin.spring") version "1.5.10"
	kotlin("plugin.jpa") version "1.5.10"
	id("org.jetbrains.kotlin.plugin.noarg") version "1.4.30"
	id ("org.sonarqube") version "3.3"
}

group = "FINALPROJECT"

version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_11

repositories {
	mavenCentral()
}

dependencies {
	implementation("org.springframework.boot:spring-boot-starter-data-jpa")
	implementation("org.springframework.boot:spring-boot-starter-web")
	implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
	implementation("org.jetbrains.kotlin:kotlin-reflect")
	implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
	runtimeOnly("org.postgresql:postgresql")


	testImplementation("org.springframework.boot:spring-boot-starter-test")
	testImplementation("org.mockito:mockito-core:3.11.2")
	testImplementation("org.mockito:mockito-inline:3.11.2")
	testImplementation("com.nhaarman.mockitokotlin2", "mockito-kotlin", "2.2.0")
	testImplementation("org.jetbrains.kotlin:kotlin-test:1.4.30")
	testImplementation("org.jetbrains.kotlin:kotlin-test-junit:1.4.30")
}

tasks.withType<KotlinCompile> {
	kotlinOptions {
		freeCompilerArgs = listOf("-Xjsr305=strict")
		jvmTarget = "11"
	}
}

tasks.withType<Test> {
	useJUnitPlatform()
}
