package kr.co.redbrush.microservice.app.controller

import kr.co.redbrush.microservice.app.data.Account
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController

@RestController
class AccountController {
    @Autowired
    lateinit var myAccount : Account

    @RequestMapping("/account", method = [RequestMethod.GET])
    fun getAccount() = myAccount
}