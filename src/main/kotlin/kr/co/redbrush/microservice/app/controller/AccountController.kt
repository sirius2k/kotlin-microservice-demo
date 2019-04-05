package kr.co.redbrush.microservice.app.controller

import kr.co.redbrush.microservice.app.data.Account
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
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

    @RequestMapping("/account", method = [RequestMethod.POST])
    fun createAccount(@RequestBody account : Account) {
        accounts[account.id] = account
    }

    @RequestMapping("/account/{id}", method = [RequestMethod.PUT])
    fun updateAccount(@PathVariable id: String, @RequestBody account: Account) {
        accounts.remove(id)
        accounts[account.id] = account
    }

    @RequestMapping("/account/{id}", method = [RequestMethod.DELETE])
    fun deleteAccount(@PathVariable id: String) = accounts.remove(id)
}