package com.example.user.controller

import com.example.user.model.RegisterUserRequest
import com.example.user.model.RegisterUserResult
import com.example.user.service.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class UserController(
        @Autowired private val userService: UserService
) {

    @PostMapping("/v1/users")
    fun registerUser(@RequestBody registerUserRequest: RegisterUserRequest): ResponseEntity<RegisterUserResult> {
        val result = userService.registerUser(registerUserRequest)
        return ResponseEntity.ok(result)
    }
}