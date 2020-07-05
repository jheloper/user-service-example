package com.example.user.repository

import com.example.user.entity.User
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest

@DataJpaTest
class UserRepositoryTest(
        @Autowired private val userRepository: UserRepository
) {

    @Test
    fun `Insert user`() {
        val user = User(
                email = "user@example.com"
        )
        val persisted = userRepository.saveAndFlush(user)

        println("User id: ${persisted.id}")
        Assertions.assertNotNull(persisted)
    }
}