package com.example.firstservice

import jakarta.servlet.http.HttpServletRequest
import org.springframework.core.env.Environment
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestHeader
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/first-service") // http://localhost:8081/first-service/welcome
class FirstServiceController(
    var env: Environment
) {

    @GetMapping("/welcome")
    fun welcome(): String {
        return "Welcome to the First service."
    }

    @GetMapping("/message")
    fun message(@RequestHeader("f-request") header: String?): String {
        println(header)
        return "Hello World in First Service."
    }

    @GetMapping("/check")
    fun check(request: HttpServletRequest): String {
        println("Server port= ${request.serverPort}")

        return String.format(
            "Hi, there. This is a message from First Service on PORT %s",
            env.getProperty("local.server.port")
        )
    }
}