package uk.co.logiccache

import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringRunner

@RunWith(SpringRunner::class)
@SpringBootTest
class KotlinHelloWorldApplicationTests {

    @Test
    fun context_loads() {
    }

    @Test
    fun test_main() {
        val args = arrayOf<String>()
        main(args)
    }
}