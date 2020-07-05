package com.example.user.integration

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.web.client.TestRestTemplate

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class UserIntegrationTest(
        @Autowired val restTemplate: TestRestTemplate
) {

    @BeforeAll
    fun setUpAll() {
        println("Before all!")
    }

    @Test
    fun `Get hello message`() {
        val response = restTemplate.getForEntity("/", String::class.java)

        println(response)
        Assertions.assertTrue(response.statusCode.is2xxSuccessful)
        Assertions.assertEquals("Hello, This is user service example!", response.body)
    }
}