package ru.step.search.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import springfox.documentation.builders.PathSelectors
import springfox.documentation.builders.RequestHandlerSelectors
import springfox.documentation.service.ApiInfo
import springfox.documentation.service.Contact
import springfox.documentation.spi.DocumentationType
import springfox.documentation.spring.web.plugins.Docket
import springfox.documentation.swagger2.annotations.EnableSwagger2

@Configuration
@EnableSwagger2
class SwaggerConfig {
    @Bean
    fun api(): Docket =
            Docket(DocumentationType.SWAGGER_2)
                    .select()
                    .apis(RequestHandlerSelectors.basePackage("ru.step.search.controller"))
                    .paths(PathSelectors.any())
                    .build()
                    .apiInfo(getApiInfo())
                    .useDefaultResponseMessages(false)

    private fun getApiInfo(): ApiInfo =
            ApiInfo(
                    "Elasticsearch with spring boot example",
                    "Elasticsearch with spring boot example",
                    "1.0.0",
                    "",
                    Contact("test", "", ""),
                    "Apache Commons 2.0",
                    "", ArrayList())
}