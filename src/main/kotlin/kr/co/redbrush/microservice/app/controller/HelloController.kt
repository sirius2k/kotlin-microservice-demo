package kr.co.redbrush.microservice.app.controller

import org.springframework.web.bind.annotation.*

@RestController
class HelloController {
    @GetMapping("/hello")
    @ResponseBody
    fun hello() = "Hello kotlin microservice!"

    @GetMapping("/hello/{name}")
    @ResponseBody
    fun hello(@PathVariable name: String) = "Hello $name!"
}