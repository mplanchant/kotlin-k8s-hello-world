package uk.co.logiccache

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit.jupiter.SpringExtension
import org.springframework.test.web.reactive.server.WebTestClient
import org.springframework.test.web.reactive.server.expectBody

@ExtendWith(SpringExtension::class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureWebTestClient
class SimpleRouteTest {

    @Autowired
    lateinit var client: WebTestClient

    @Test
    fun hello_should_be_ok() {
        client.get()
                .uri("/hello")
                .exchange()
                .expectStatus().isOk
                .expectHeader().contentType("text/plain;charset=UTF-8")
                .expectBody<String>()
                .consumeWith { response -> assertThat(response.responseBody).isEqualTo("Hello World!") }
    }
}