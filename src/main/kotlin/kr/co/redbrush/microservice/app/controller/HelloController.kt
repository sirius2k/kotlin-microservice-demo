package kr.co.redbrush.microservice.app.controller

import org.springframework.web.bind.annotation.*

@RestController
class HelloController {
    @RequestMapping("/hello", method = [RequestMethod.GET])
    @ResponseBody
    fun hello() = "Hello kotlin microservice!"

    @RequestMapping("/hello/{name}", method = [RequestMethod.GET])
    @ResponseBody
    fun hello(@PathVariable name: String) = "Hello $name!"
}