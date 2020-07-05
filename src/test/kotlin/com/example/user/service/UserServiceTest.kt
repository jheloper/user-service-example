package com.example.user.service

import com.example.user.entity.User
import com.example.user.model.RegisterUserRequest
import com.example.user.repository.UserRepository
import io.mockk.every
import io.mockk.mockk
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class UserServiceTest {
    private val userRepository = mockk<UserRepository>()
    private val userService = UserService(userRepository)

    @Test
    fun `Register user`() {

        val email = "user@example.com"
        every { userRepository.save(any<User>()) }.returns(User(id = 1, email = email))

        val request = RegisterUserRequest(
                email = email
        )
        val user = userService.registerUser(request)

        Assertions.assertNotNull(user)
        Assertions.assertEquals(email, user.email)
    }
}