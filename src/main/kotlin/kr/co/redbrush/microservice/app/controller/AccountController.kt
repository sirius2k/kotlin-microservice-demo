package kr.co.redbrush.microservice.app.controller

import kr.co.redbrush.microservice.app.data.Account
import kr.co.redbrush.microservice.app.service.AccountService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import java.util.concurrent.ConcurrentHashMap

@RestController
class AccountController {
    @Autowired
    private lateinit var accountService: AccountService

    @GetMapping("/account/{id}")
    fun getAccount(@PathVariable id: String) = accountService.getAccount(id)

    @GetMapping("/accounts")
    fun getAccounts(@RequestParam(required = false, defaultValue = "") idFilter: String) : List<Account> {
        return accountService.searchAccounts(idFilter)
    }

    @PostMapping("/account")
    fun createAccount(@RequestBody account : Account) {
        accountService.createAccount(account)
    }

    @PutMapping("/account/{id}")
    fun updateAccount(@PathVariable id: String, @RequestBody account: Account) {
        accountService.updateAccount(id, account)
    }

    @DeleteMapping("/account/{id}")
    fun deleteAccount(@PathVariable id: String) {
        accountService.deleteAccount(id)
    }
}