package com.example.user.service

import com.example.user.entity.User
import com.example.user.model.RegisterUserRequest
import com.example.user.repository.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class UserService(
        @Autowired private val userRepository: UserRepository
) {

    fun registerUser(registerUserRequest: RegisterUserRequest): User {
        val user = User(
                email = registerUserRequest.email
        )
        return userRepository.save(user)
    }
}