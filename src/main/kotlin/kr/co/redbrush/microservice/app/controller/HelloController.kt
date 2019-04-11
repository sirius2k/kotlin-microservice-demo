package kr.co.redbrush.microservice.app.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.bind.annotation.RestController

@RestController
class HelloController {
    @GetMapping("/hello")
    @ResponseBody
    fun hello() = "Hello kotlin microservice!"

    @GetMapping("/hello/{name}")
    @ResponseBody
    fun hello(@PathVariable name: String) = "Hello $name!"
}