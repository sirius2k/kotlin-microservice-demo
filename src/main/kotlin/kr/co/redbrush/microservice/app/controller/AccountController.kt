package kr.co.redbrush.microservice.app.controller

import kr.co.redbrush.microservice.app.data.Account
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import java.util.concurrent.ConcurrentHashMap

@RestController
class AccountController {
    @Autowired
    lateinit var accounts : ConcurrentHashMap<String, Account>

    @RequestMapping("/account", method = [RequestMethod.GET])
    fun getAccount() = accounts["test"]

    @RequestMapping("/accounts", method = [RequestMethod.GET])
    fun getAccounts(@RequestParam(required = false, defaultValue = "") id: String) : List<Account> {
        return accounts.filter {
            it.value.id.contains(id, true)
        }.map(Map.Entry<String, Account>::value).toList()
    }
}