package uk.co.logiccache

import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringRunner
import org.springframework.test.web.reactive.server.WebTestClient

@RunWith(SpringRunner::class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureWebTestClient
class SimpleRouteTest {

    lateinit var client: WebTestClient

    @Before
    fun init() {
        this.client = WebTestClient.bindToRouterFunction(SimpleRoute().route()).build()
    }

    @Test
    fun hello_should_be_ok() {
        client.get()
                .uri("/hello")
                .exchange()
                .expectStatus().isOk
    }
}