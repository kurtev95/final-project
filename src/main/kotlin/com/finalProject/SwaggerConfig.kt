package com.finalProject

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.HttpHeaders
import springfox.documentation.builders.PathSelectors
import springfox.documentation.builders.RequestHandlerSelectors
import springfox.documentation.service.ApiKey
import springfox.documentation.service.AuthorizationScope
import springfox.documentation.service.SecurityReference
import springfox.documentation.spi.DocumentationType
import springfox.documentation.spi.service.contexts.SecurityContext
import springfox.documentation.spring.web.plugins.Docket
import springfox.documentation.swagger2.annotations.EnableSwagger2
import java.time.LocalDateTime

@Configuration
@EnableSwagger2
class SwaggerConfig {

    private fun apiKey(): ApiKey {
        return ApiKey("JWT", HttpHeaders.AUTHORIZATION, "header")
    }

    private fun securityContext(): SecurityContext {
        return SecurityContext.builder().securityReferences(defaultAuth()).build()
    }

    private fun defaultAuth(): List<SecurityReference> {
        val authorizationScope = AuthorizationScope("global", "accessEverything")
        val securityReference = SecurityReference("JWT", arrayOf(authorizationScope))
        return listOf(securityReference)
    }

    @Bean
    fun api(): Docket {
        return Docket(DocumentationType.SWAGGER_2)
//                .directModelSubstitute(LocalDateTime::class.java, String::class.java)
            .securityContexts(listOf(securityContext()))
            .securitySchemes(listOf(apiKey()))
            .select()
            .apis(RequestHandlerSelectors.basePackage("com.finalProject"))
            .paths(PathSelectors.any())
            .build()
    }
}