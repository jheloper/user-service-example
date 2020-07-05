package com.example.user.integration

import com.example.user.model.RegisterUserRequest
import com.example.user.model.RegisterUserResult
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.http.HttpEntity

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
        Assertions.assertFalse(response.body.isNullOrBlank())
        Assertions.assertEquals("Hello, This is user service example!", response.body)
    }

    @Test
    fun `Register user`() {
        val email = "user@example.com"
        val request = RegisterUserRequest(
                email = email
        )
        val requestEntity = HttpEntity(request)

        val response = restTemplate.postForEntity("/v1/users", requestEntity, RegisterUserResult::class.java)

        println(response)
        Assertions.assertTrue(response.statusCode.is2xxSuccessful)
        Assertions.assertNotNull(response.body)
        Assertions.assertEquals(email, response.body!!.email)
    }
}