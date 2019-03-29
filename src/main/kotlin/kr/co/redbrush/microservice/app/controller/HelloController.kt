package kr.co.redbrush.microservice.app.controller

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.ResponseBody

@Controller
class HelloController {
    @RequestMapping("/hello", method = [RequestMethod.GET])
    @ResponseBody
    fun hello() = "Hello kotlin microservice!"

    @RequestMapping("/hello/{name}", method = [RequestMethod.GET])
    @ResponseBody
    fun hello(@PathVariable name: String) = "Hello $name!"
}