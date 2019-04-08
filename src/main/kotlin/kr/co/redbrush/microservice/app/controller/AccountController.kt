package kr.co.redbrush.microservice.app.controller

import kr.co.redbrush.microservice.app.data.Account
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import java.util.concurrent.ConcurrentHashMap

@RestController
class AccountController {
    @Autowired
    lateinit var accounts : ConcurrentHashMap<String, Account>

    @GetMapping("/account")
    fun getAccount() = accounts["test"]

    @GetMapping("/accounts")
    fun getAccounts(@RequestParam(required = false, defaultValue = "") id: String) : List<Account> {
        return accounts.filter {
            it.value.id.contains(id, true)
        }.map(Map.Entry<String, Account>::value).toList()
    }

    @PostMapping("/account")
    fun createAccount(@RequestBody account : Account) {
        accounts[account.id] = account
    }

    @PutMapping("/account/{id}")
    fun updateAccount(@PathVariable id: String, @RequestBody account: Account) {
        accounts.remove(id)
        accounts[account.id] = account
    }

    @DeleteMapping("/account/{id}")
    fun deleteAccount(@PathVariable id: String) = accounts.remove(id)
}