package uk.co.logiccache

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.reactive.function.server.ServerResponse
import org.springframework.web.reactive.function.server.router

@Configuration
class SimpleRoute {
    @Bean
    fun route() = router {
        GET("/hello") {
            ServerResponse.ok().bodyValue("Hello World!")
        }
    }
}