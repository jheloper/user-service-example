package com.example.user

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.context.ApplicationContext

@SpringBootTest
class UserServiceExampleApplicationTests {

	@Autowired
	private lateinit var applicationContext: ApplicationContext

	@Test
	fun contextLoads() {
		println(applicationContext.id)
		Assertions.assertNotNull(applicationContext)
	}
}
