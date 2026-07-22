package com.example.secondservice

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestHeader
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/second-service") // http://localhost:8082/second-service/welcome
class SecondServiceController {

    @GetMapping("/welcome")
    fun welcome(): String {
        return "Welcome to the Second service."
    }

    @GetMapping("/message")
    fun message(@RequestHeader("s-request") header: String?): String {
        println(header)
        return "Hello World in Second Service."
    }

    @GetMapping("/check")
    fun check(): String {
        return "Hi, there. This is a message from Second Service."
    }
}