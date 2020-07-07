package com.example.user.controller

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping

@Controller
class WebController {

    @GetMapping("/web/user")
    fun getUserView(): String {
        return "user"
    }
}