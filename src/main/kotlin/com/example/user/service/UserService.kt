package com.example.user.service

import com.example.user.entity.User
import com.example.user.model.RegisterUserRequest
import com.example.user.model.RegisterUserResult
import com.example.user.repository.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class UserService(
        @Autowired private val userRepository: UserRepository
) {

    fun registerUser(registerUserRequest: RegisterUserRequest): RegisterUserResult {
        val user = User(
                email = registerUserRequest.email
        )
        val persisted = userRepository.save(user)
        return RegisterUserResult(id = persisted.id!!, email = persisted.email)
    }
}